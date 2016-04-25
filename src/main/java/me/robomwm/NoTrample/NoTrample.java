package me.robomwm.NoTrample;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Robo on 4/24/2016.
 */
public class NoTrample extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    void onTrampleBlock(EntityChangeBlockEvent event)
    {
        //We only care about players
        if (event.getEntityType() != EntityType.PLAYER)
            return;
            
        if (event.getTo() == Material.DIRT && event.getBlock().getType() == Material.SOIL)
            event.setCancelled(true);
    }
}
