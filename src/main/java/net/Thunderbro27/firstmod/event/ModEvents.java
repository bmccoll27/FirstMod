package net.Thunderbro27.firstmod.event;

import net.Thunderbro27.firstmod.MyFirstMod;
import net.Thunderbro27.firstmod.effects.ModEffects;
import net.Thunderbro27.firstmod.item.ModItems;
import net.Thunderbro27.firstmod.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = MyFirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of
    // https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos
                        || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void LivingDamageEvent(LivingDamageEvent event) {
        if (event.getSource().getDirectEntity() instanceof Player player
                && player.getMainHandItem().is(ModItems.RUBY_SWORD.get())) {
            if ((int) player.getY() <= 48) {

                float dmg = event.getAmount();
                event.setAmount(dmg + 9);
            }
        }
    }

    @SubscribeEvent
    public static void LivingDeathEvent(LivingDamageEvent event) {
        /*if (event.getSource().getDirectEntity() instanceof LivingEntity livingEntity
                && livingEntity.hasEffect(ModEffects.TICKING.get())) {

        }*/
    }

}
