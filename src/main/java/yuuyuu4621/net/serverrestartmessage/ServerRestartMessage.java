package yuuyuu4621.net.serverrestartmessage;

import org.bukkit.plugin.java.JavaPlugin;
import yuuyuu4621.net.serverrestartmessage.commands.fly;
import yuuyuu4621.net.serverrestartmessage.commands.restartmessage;

public final class ServerRestartMessage extends JavaPlugin {

    @Override
    public void onEnable()
    {

        getCommand("restartmessage").setExecutor(new restartmessage());
        getCommand("fly").setExecutor(new fly());
    }

    @Override
    public void onDisable() {
    }
}
