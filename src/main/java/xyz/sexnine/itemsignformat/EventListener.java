package xyz.sexnine.itemsignformat;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.logging.Logger;

public class EventListener implements Listener {
    private final Logger logger;

    public EventListener(Logger logger) {
        this.logger = logger;
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        if (event.getPlayer().hasPermission("itemsignformat.sign.color") || event.getPlayer().isOp()) {
            for (int i = 0; i < 3; i++) {
                event.setLine(i, Formatter.applyColors(event.getLine(i)));
            }
        }

        if (event.getPlayer().hasPermission("itemsignformat.sign.formatting") || event.getPlayer().isOp()) {
            for (int i = 0; i < 3; i++) {
                event.setLine(i, Formatter.applyFormatting(event.getLine(i)));
            }
        }
    }

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        HumanEntity player = event.getView().getPlayer();
        ItemStack resultingItem = event.getResult();
        String renameText = event.getInventory().getRenameText();

        if (resultingItem == null || renameText == null) {
            return;
        }

        ItemMeta itemMeta = resultingItem.getItemMeta();
        if (itemMeta == null) {
            return;
        }

        String newName = renameText;

        if (player.hasPermission("itemsignformat.anvil.color") || player.isOp()) {
            newName = Formatter.applyColors(newName);
        }
        if (player.hasPermission("itemsignformat.anvil.formatting") || player.isOp()) {
            newName = Formatter.applyFormatting(newName);
        }

        itemMeta.setDisplayName(newName);
        resultingItem.setItemMeta(itemMeta);
        event.setResult(resultingItem);
    }
}
