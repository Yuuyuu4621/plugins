package yuuyuu4621.net.serverrestartmessage.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class kwhitelist extends JavaPlugin implements CommandExecutor {

    private boolean whitelistEnabled = false;
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "あなたには権限がありません！");
            return true;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("on")) {
                enableWhitelist(sender);
            } else if (args[0].equalsIgnoreCase("off")) {
                disableWhitelist(sender);
            } else {
                sender.sendMessage(ChatColor.RED + "使用法: /kwhitelist onまたは/kwhitelist off");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "使用法: /kwhitelist onまたは/kwhitelist off");
        }

        return true;
    }

    private void enableWhitelist(CommandSender sender) {
        if (!whitelistEnabled) {
            whitelistEnabled = true;
            kickNonOPPlayers();
            sender.sendMessage(ChatColor.GREEN + "ホワイトリストを有効にし、OP権限を持っていないプレイヤーをキックしました。");
        } else {
            sender.sendMessage(ChatColor.RED + "ホワイトリストは既に有効です。");
        }
    }

    private void disableWhitelist(CommandSender sender) {
        if (whitelistEnabled) {
            whitelistEnabled = false;
            sender.sendMessage(ChatColor.GREEN + "ホワイトリストを解除しました。");
        } else {
            sender.sendMessage(ChatColor.RED + "ホワイトリストは既に解除されています。");
        }
    }

    private void kickNonOPPlayers() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            if (!player.isOp()) {
                player.kickPlayer(ChatColor.RED + "ホワイトリストが有効になりました。OP権限がないためサーバーからキックされました。");
            }
        }
    }
}
