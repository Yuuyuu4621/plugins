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
        if (!commandSender.isOp())//OP餅以外の実行を拒否
        {
            commandSender.sendMessage(ChatColor.RED + "あなたには権限がありません！ (You don't have permission!)");//実行者がOPを持っていなかった時の処理
            return true;
        }
        commandSender.sendMessage(ChatColor.GREEN + "実行しました！");//実行時の処理
        final Player p = (Player) commandSender;//Playerをpと宣言
        String title = ChatColor.RED + "サーバー再起動";//実行時の処理

        p.sendTitle("", title, 10, 70, 20);//フェードアウト・フェードインの時間指定
        return true;
    }
}
