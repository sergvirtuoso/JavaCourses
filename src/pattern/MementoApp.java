package pattern;

public class MementoApp{
    public static void main(String[] args){
        Game game = new Game();
        game.set("LVL_1", 3000);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("LLV_2", 5500);
        System.out.println(game);

        System.out.println("Loading");
        game.load(file.getSave());
        System.out.println(game);
    }
}
class Game{
    private String level;
    private int ms;
    public void set(String level, int ms){this.level = level; this.ms = ms;}
    public void load(Save save){
        level = save.getLevel();
    }
    public Save save(){
        return new Save(level, ms);
    }
    public String toString() {
        return "Game [level =" + level + ", ms" + ms + "]";
    }

}
class Save{
    private final String level;
    private final int ms;
    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    public int getMs() { return ms; }
    public String getLevel() { return level; }
}
class File{
    Save save;
    public Save getSave() { return save; }
    public void setSave(Save save) { this.save = save; }
}