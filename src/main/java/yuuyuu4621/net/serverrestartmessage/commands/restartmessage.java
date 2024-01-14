package yuuyuu4621.net.serverrestartmessage.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class restartmessage implements CommandExecutor
{

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        if (!commandSender.isOp())
        {
            commandSender.sendMessage(ChatColor.RED + "あなたには権限がありません！ (You don't have permission!)");
            return true;
        }
        final Player p = (Player) commandSender;
        String title = "test";

        p.sendTitle("", title, 10, 70, 20);
        return true;
    }
}
