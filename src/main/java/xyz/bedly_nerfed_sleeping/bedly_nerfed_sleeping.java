package xyz.bedly_nerfed_sleeping;

import net.minecraftforge.fml.common.Mod;

/*
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*/
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(bedly_nerfed_sleeping.MODID)
public class bedly_nerfed_sleeping
{
    public static final String MODID = "bedly_nerfed_sleeping";
    /*
    //log4j logger
    private static final Logger LOGGER = LogManager.getLogger(MODID);
    */
   //slf4j logger

   private static final Logger LOGGER = LogUtils.getLogger();

    public bedly_nerfed_sleeping()
    {
        LOGGER.info("slf4j!");
    }
}
