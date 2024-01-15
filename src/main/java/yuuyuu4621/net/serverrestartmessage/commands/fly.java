package yuuyuu4621.net.serverrestartmessage.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class fly implements CommandExecutor
{

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        if (!commandSender.isOp())
        {
            commandSender.sendMessage(ChatColor.RED + "あなたには権限がありません！ (You don't have permission!");
            return true;
        }
        final Player p = (Player) commandSender;
        if (p.getAllowFlight())
        {
            p.setAllowFlight(false);
            commandSender.sendMessage(ChatColor.RED + "FLYモードを無効化しました。");
            return true;
        }

            p.setAllowFlight(true);
        commandSender.sendMessage(ChatColor.GREEN + "FLYモードを有効化しました。");
        return true;
    }
}
