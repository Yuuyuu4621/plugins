package yuuyuu4621.net.serverrestartmessage.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
        commandSender.sendMessage(ChatColor.BLUE + "実行しました！ (Excuted!)");
        return true;
    }
}
