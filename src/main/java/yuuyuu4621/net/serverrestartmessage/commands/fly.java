package yuuyuu4621.net.serverrestartmessage.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class fly implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) {
            // セレクターが指定されていない場合
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "このコマンドはプレイヤーのみが実行できます！");
                return true;
            }

            Player player = (Player) commandSender;

            // 以下の処理は以前のコードと同じ
            if (!player.isOp()) {
                player.sendMessage(ChatColor.RED + "あなたには権限がありません！ (You don't have permission!");
                return true;
            }

            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.RED + "FLYモードを無効化しました。");
            } else {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.GREEN + "FLYモードを有効化しました。");
            }

            return true;
        } else {
            // セレクターが指定されている場合
            if (!commandSender.isOp()) {
                commandSender.sendMessage(ChatColor.RED + "あなたには権限がありません！ (You don't have permission!");
                return true;
            }

            Player targetPlayer = Bukkit.getPlayer(strings[0]);

            if (targetPlayer == null || !targetPlayer.isOnline()) {
                commandSender.sendMessage(ChatColor.RED + "プレイヤー " + strings[0] + " はオンラインではありません！");
                return true;
            }

            if (targetPlayer.getAllowFlight()) {
                targetPlayer.setAllowFlight(false);
                commandSender.sendMessage(ChatColor.RED + targetPlayer.getName() + " のFLYモードを無効化しました。");
            } else {
                targetPlayer.setAllowFlight(true);
                commandSender.sendMessage(ChatColor.GREEN + targetPlayer.getName() + " のFLYモードを有効化しました。");
            }

            return true;
        }
    }
}
