package yuuyuu4621.net.serverrestartmessage.commands;

import io.papermc.paper.event.player.AsyncChatCommandDecorateEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class countdown implements CommandExecutor
{

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        if (!commandSender.isOp())
        {
            commandSender.sendMessage(ChatColor.RED + "あなたには権限がありません！ (You don't have permission!)");
            return true;
        }
        commandSender.sendMessage(ChatColor.BLUE + "正常に実行されました！");

        final Player p = (Player) commandSender;

        if (p.getAllowFlight())
        {
            commandSender.sendMessage(ChatColor.RED + "Flyモードを無効にしました。");
            return true;
        }

        p.setAllowFlight(true);
        commandSender.sendMessage(ChatColor.GREEN + "Flyモードを有効にしました。");
        return true;
    }
}
