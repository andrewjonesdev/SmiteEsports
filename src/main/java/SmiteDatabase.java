import org.jruby.embed.LocalVariableBehavior;
import org.jruby.embed.ScriptingContainer;

/**
 * Created by andrewdjones on 8/15/17.
 */
public class SmiteDatabase {

    public static void main (String args[]){
        //MyHelloWorld();
        //String j = MyHelloWorldStr();
        //System.out.println(j);
        SplData();
    }

    private static void MyHelloWorld() {
        ScriptingContainer container = new ScriptingContainer();
        container.runScriptlet("puts 'Hello World!'");
    }

    private static String MyHelloWorldStr(){
        ScriptingContainer container = new ScriptingContainer();
       return container.runScriptlet("'Hello World!'").toString();
    }

    private static String SplData(){
        ScriptingContainer container = new ScriptingContainer(LocalVariableBehavior.PERSISTENT);
        //container.setHomeDirectory("/jruby-9.0.5.0");
        return container.runScriptlet(" require 'rubygems'\n" +
                "require 'open-uri'\n" +
                "require 'nokogiri'\n" +
                "\n" +
                "url = 'http://esports.smitegame.com/s4-spring-split-landing-page/'\n" +
                "page = Nokogiri::HTML(open(url))\n" +
                "\n" +
                "page.css('.overview-wrapper td').each do |line|\n" +
                "  puts line.text\n" +
                "end\n" +
                "\n" +
                "page.css('.overview-wrapper td a img').map do |image|\n" +
                "  puts image['src']\n" +
                "end\n" +
                "\n" +
                "page.css('.overview-wrapper td a').map do |link|\n" +
                "  puts link['href']\n" +
                "  urlTeam =link['href']\n" +
                "  pageTeam = Nokogiri::HTML(open(urlTeam))\n" +
                "  pageTeam.css('div.player-card').each do |captain|\n" +
                "    captain.to_s.include?(\"captain-icon ion-star\") ? (puts \"true\") : (puts \"false\")\n" +
                "  end\n" +
                "  pageTeam.css('div.player-card a').map do |plink|\n" +
                "    puts plink['href']\n" +
                "    urlPlayer =plink['href']\n" +
                "    pagePlayer = Nokogiri::HTML(open(urlPlayer))\n" +
                "    puts pagePlayer.css('div.player-tag p').first.text\n" +
                "    puts pagePlayer.css('div.player-name p').first.text\n" +
                "    pagePlayer.css('div.role img').map do |pimage|\n" +
                "      puts pimage['src']\n" +
                "      break\n" +
                "    end\n" +
                "    puts pagePlayer.css('div.role p').first.text\n" +
                "    age = pagePlayer.css('div.player-age p').first\n" +
                "    puts \"%s\" % [age ? age.text : \"0\"]\n" +
                "    #if pagePlayer.css('div.player-age p').first.nil?\n" +
                "    #  puts \"N/A\"\n" +
                "    #else\n" +
                "    #  puts pagePlayer.css('div.player-age p').first.text\n" +
                "    #end\n" +
                "    location = pagePlayer.css('div.player-location p').first\n" +
                "    puts \"%s\" % [location ? location.text : \"N/A\"]\n" +
                "    pagePlayer.css('div.social-media div[class=\"social twitch\"] a').map do |plink|\n" +
                "      puts plink['href']\n" +
                "      break\n" +
                "    end\n" +
                "    pagePlayer.css('div.social-media div[class=\"social twitter\"] a').map do |plink|\n" +
                "      puts plink['href']\n" +
                "      break\n" +
                "    end\n" +
                "    puts pagePlayer.css('div.main-content div.player-bio-wrapper p').text\n" +
                "    pagePlayer.css('div.statistics-wrapper table.statistics-table td').map do |ptable|\n" +
                "      puts ptable.text\n" +
                "    end\n" +
                "\n" +
                "    pagePlayer.css('div.player-card div.player-image img').map do |pimage|\n" +
                "      puts pimage['src']\n" +
                "    end\n" +
                "    pagePlayer.css('div.top-gods-wrapper table.top-gods-table td img').map do |ptable|\n" +
                "      puts ptable['src']\n" +
                "    end\n" +
                "    pagePlayer.css('div.top-gods-wrapper table.top-gods-table td').map do |ptable|\n" +
                "      puts ptable.text\n" +
                "    end\n" +
                "  end\n" +
                "end\n" +
                "\n" +
                "\n" +
                "#urlTeam = 'http://esports.smitegame.com/team/spacestation-gaming/'\n" +
                "#pageTeam = Nokogiri::HTML(open(urlTeam))\n" +
                "\n" +
                "#puts page.css('li.toclevel-3').text\n" +
                "#pageTeam.css('div.player-card a').map do |plink|\n" +
                "#  puts plink['href']\n" +
                "#end\n" +
                "#pageTeam.css('div.player-card div.player-image img').map do |pimage|\n" +
                "#  puts pimage['src']\n" +
                "#end\n" +
                "\n").toString();
    }
}
