import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    HealthBar healthbar = new HealthBar();
    Counter counter = new Counter();
    boolean bossLevel = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        prepare();
    }

    public Counter getCounter()
    {
        return counter;
    }
    
    public HealthBar getHealthbar()
    {
        return healthbar;
    }
    
    public void act()
    {
       addEnemy1();
       addEnemy2();
       Boss();
    }
    
    public void addEnemy1()
    {
       if (Greenfoot.getRandomNumber(180)<1)
       {
           addObject(new Enemy1(), Greenfoot.getRandomNumber(600), 0);
       }
    }
    public void addEnemy2()
    {
       if (Greenfoot.getRandomNumber(120)<1)
       {
           addObject(new Enemy2(), Greenfoot.getRandomNumber(600), 0);
       }
    }
    public void Boss()
    {
        if (counter.score == 25 || counter.score == 26)
        {
            if (bossLevel == false)
            {
                addObject(new Boss(), 300, 0);
                bossLevel = true;
            }
            
        }
    }
    
    private void prepare()
    {
        addObject(counter, 85, 30);
        addObject(healthbar,220, 32);
        Player player = new Player();
        addObject(player,252,525);
        player.setLocation(300,530);
    }
}
