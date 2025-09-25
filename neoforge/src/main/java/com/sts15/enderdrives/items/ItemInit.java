package com.sts15.enderdrives.items;

import appeng.api.stacks.AEKeyType;
import com.sts15.enderdrives.Constants;
import com.sts15.enderdrives.config.serverConfig;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public static final DeferredHolder<Item, Item> ENDER_ITEM_CELL_HOUSING =
            ITEMS.register("ender_item_cell_housing", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_1K =
            ITEMS.register("item_storage_cell_1k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_1K_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_4K =
            ITEMS.register("item_storage_cell_4k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_4K_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_16K =
            ITEMS.register("item_storage_cell_16k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_16K_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_64K =
            ITEMS.register("item_storage_cell_64k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_64K_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_256K =
            ITEMS.register("item_storage_cell_256k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_256K_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_1M =
            ITEMS.register("item_storage_cell_1m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_1M_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_4M =
            ITEMS.register("item_storage_cell_4m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_4M_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_16M =
            ITEMS.register("item_storage_cell_16m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_16M_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_64M =
            ITEMS.register("item_storage_cell_64m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_64M_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_256M =
            ITEMS.register("item_storage_cell_256m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_256M_TYPE_LIMIT.get(), AEKeyType.items()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_DISK_creative =
            ITEMS.register("item_storage_cell_creative", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_CREATIVE_TYPE_LIMIT.get(), AEKeyType.items()));

    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_1K =
            ITEMS.register("fluid_storage_cell_1k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_1K_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_4K =
            ITEMS.register("fluid_storage_cell_4k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_4K_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_16K =
            ITEMS.register("fluid_storage_cell_16k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_16K_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_64K =
            ITEMS.register("fluid_storage_cell_64k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_64K_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_256K =
            ITEMS.register("fluid_storage_cell_256k", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_256K_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_1M =
            ITEMS.register("fluid_storage_cell_1m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_1M_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_4M =
            ITEMS.register("fluid_storage_cell_4m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_4M_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_16M =
            ITEMS.register("fluid_storage_cell_16m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_16M_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_64M =
            ITEMS.register("fluid_storage_cell_64m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_64M_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_256M =
            ITEMS.register("fluid_storage_cell_256m", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_256M_TYPE_LIMIT.get(), AEKeyType.fluids()));
    public static final DeferredHolder<Item, EnderDiskItem> ENDER_FLUID_DISK_creative =
            ITEMS.register("fluid_storage_cell_creative", () -> new EnderDiskItem(new Item.Properties(), () -> serverConfig.ENDER_DISK_CREATIVE_TYPE_LIMIT.get(), AEKeyType.fluids()));

    public static final DeferredHolder<Item, TapeDiskItem> TAPE_DISK =
            ITEMS.register("tape_disk", () -> new TapeDiskItem(new Item.Properties(), () -> serverConfig.TAPE_DISK_TYPE_LIMIT.get()));

    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_1K = ITEMS.register("cell_component_1k", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_4K = ITEMS.register("cell_component_4k", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_16K = ITEMS.register("cell_component_16k", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_64K = ITEMS.register("cell_component_64k", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_256K = ITEMS.register("cell_component_256k", () -> new Item(new Item.Properties()) {});

    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_1M = ITEMS.register("cell_component_1m", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_4M = ITEMS.register("cell_component_4m", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_16M = ITEMS.register("cell_component_16m", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_64M = ITEMS.register("cell_component_64m", () -> new Item(new Item.Properties()) {});
    public static final DeferredHolder<Item, Item> ENDER_STORAGE_COMPONENT_256M = ITEMS.register("cell_component_256m", () -> new Item(new Item.Properties()) {});

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}