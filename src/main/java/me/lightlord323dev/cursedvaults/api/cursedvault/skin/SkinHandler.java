package me.lightlord323dev.cursedvaults.api.cursedvault.skin;

import me.lightlord323dev.cursedvaults.Main;
import me.lightlord323dev.cursedvaults.api.handler.Handler;
import me.lightlord323dev.cursedvaults.util.NBTApi;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luda on 8/19/2020.
 */
public class SkinHandler implements Handler {

    private List<ItemStack> skins;

    @Override
    public void onLoad() {
        this.skins = new ArrayList<>();
        Main.getInstance().getSkinData().getConfig().getStringList("skins").forEach(str -> {
            Material type = Material.getMaterial(str);
            ItemStack skin;
            if (type == null) {
                skin = SkinUtils.getCustomTextureHead(str);
            } else {
                skin = new ItemStack(type);
            }
            skin = new NBTApi(skin).setBoolean("cvSkinItem", true).getItemStack();
            this.skins.add(skin);
        });
        System.out.println("[Cursed Vaults] Skin data has been cached");
    }

    @Override
    public void onUnload() {

    }

    public ItemStack getSkin(int id) {
        return this.skins.get(id - 1);
    }

    public boolean isValidId(int id) {
        return id - 1 >= 0 && id - 1 < this.skins.size();
    }
}
