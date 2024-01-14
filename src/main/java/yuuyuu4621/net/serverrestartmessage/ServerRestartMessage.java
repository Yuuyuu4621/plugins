package yuuyuu4621.net.serverrestartmessage;

import org.bukkit.plugin.java.JavaPlugin;
import yuuyuu4621.net.serverrestartmessage.commands.countdown;
import yuuyuu4621.net.serverrestartmessage.commands.restartmessage;

public final class ServerRestartMessage extends JavaPlugin {

    @Override
    public void onEnable()
    {

        getCommand("restartmessage").setExecutor(new restartmessage());
        getCommand("countdown").setExecutor(new countdown());
    }

    @Override
    public void onDisable() {
    }
}
