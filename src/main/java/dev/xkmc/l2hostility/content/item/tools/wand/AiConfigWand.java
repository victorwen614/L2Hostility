package dev.xkmc.l2hostility.content.item.tools.wand;

import dev.xkmc.l2hostility.init.data.LangData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AiConfigWand extends BaseWand {

	public AiConfigWand(Properties properties) {
		super(properties);
	}

	@Override
	public void clickTarget(ItemStack stack, Player player, LivingEntity entity) {
		if (entity instanceof Mob mob) {
			mob.setNoAi(!mob.isNoAi());
			player.sendSystemMessage(LangData.MSG_AI.get(mob.getDisplayName(), mob.isNoAi()));
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		list.add(LangData.ITEM_WAND_AI.get().withStyle(ChatFormatting.GRAY));
	}

}
