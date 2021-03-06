package minestrapp.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import minestrapp.Reference;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.id, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    public static final String CAT_GENERAL = "general";
    public static final String CAT_WORLD = "World Generation";
    public static final String SUBCAT_ORE = "Ores";
    public static final String SUBCAT_STONE = "Stones";

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.BooleanValue GEN_COPPER;
    public static ForgeConfigSpec.IntValue GEN_COPPER_VEIN_SIZE;
    public static ForgeConfigSpec.BooleanValue GEN_TIN;
    public static ForgeConfigSpec.IntValue GEN_TIN_VEIN_SIZE;
    public static ForgeConfigSpec.BooleanValue GEN_DIMENSIUM;
    public static ForgeConfigSpec.IntValue GEN_DIMENSIUM_VEIN_SIZE;

    public static ForgeConfigSpec.ConfigValue<List<String>> STONE_GEN_DIMS;
    public static ForgeConfigSpec.BooleanValue GEN_OCEANSTONE;
    public static ForgeConfigSpec.BooleanValue GEN_ICESTONE;
    public static ForgeConfigSpec.BooleanValue GEN_COLDSTONE;
    public static ForgeConfigSpec.BooleanValue GEN_REDROCK;
    public static ForgeConfigSpec.BooleanValue GEN_DEEPSTONE;
    public static ForgeConfigSpec.BooleanValue GEN_INVINCIUM;

    public static ForgeConfigSpec.DoubleValue MAX_STARTING_HEALTH;

    static {
        COMMON_BUILDER.comment("General Settings").push(CAT_GENERAL);
        MAX_STARTING_HEALTH = COMMON_BUILDER.comment("Starting health").defineInRange("health", 10D, 2D, 40D);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("World Generation Settings").push(CAT_WORLD);
        COMMON_BUILDER.comment("Ores").push(SUBCAT_ORE);
        GEN_COPPER = COMMON_BUILDER.comment("Should the world contain copper?").define("copper", true);
        GEN_COPPER_VEIN_SIZE = COMMON_BUILDER.comment("Copper vein size.").defineInRange("copper_vein", 5, 1, 50);
        GEN_TIN = COMMON_BUILDER.comment("Should the world contain tin?").define("tin", true);
        GEN_TIN_VEIN_SIZE = COMMON_BUILDER.comment("Tin vein size.").defineInRange("tin_vein", 5, 1, 50);
        GEN_DIMENSIUM = COMMON_BUILDER.comment("Should the end contain dimensium?").define("dimensium", true);
        GEN_DIMENSIUM_VEIN_SIZE = COMMON_BUILDER.comment("Dimensium vein size.").defineInRange("dimensium_vein", 8, 1, 50);
        COMMON_BUILDER.comment("Stones").push(SUBCAT_STONE);
        STONE_GEN_DIMS = COMMON_BUILDER.comment("Dimension IDs to generate stone variants (if they exist in that dim)").define("gen_dim_ids", new ArrayList<String>(Arrays.asList("0")));
        GEN_OCEANSTONE = COMMON_BUILDER.comment("Should the world generate oceanstone?").define("oceanstone", true);
        GEN_ICESTONE = COMMON_BUILDER.comment("Should the world generate icestone?").define("icestone", true);
        GEN_COLDSTONE = COMMON_BUILDER.comment("Should the world generate coldstone?").define("coldstone", true);
        GEN_REDROCK = COMMON_BUILDER.comment("Should the world generate redrock?").define("redrock", true);
        GEN_DEEPSTONE = COMMON_BUILDER.comment("Should the world generate deepstone and deepstone variants?").define("deepstone", true);
        GEN_INVINCIUM = COMMON_BUILDER.comment("Should the world generate invincium under bedrock?").define("invincium", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path){
        final CommentedFileConfig configData =  CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

        configData.load();
        spec.setConfig(configData);
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading e){

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading e){

    }
}
