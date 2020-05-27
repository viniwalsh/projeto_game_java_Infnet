import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    int timesHit = 2;
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Enemy1()
    {
        setRotation(90);
    }
    public void act() 
    {
        moveEnemy();
        hitByProjectile();
    }
    
    public void hitByProjectile()
    {
       Actor projectile = getOneIntersectingObject(Projectile.class);
       if (projectile != null)
       {
         getWorld().removeObject(projectile);
         timesHit--;
       }
       if (timesHit == 0)
       {
         World world = getWorld();
         MyWorld myWorld = (MyWorld)world;
         Counter counter = myWorld.getCounter();
         counter.addScore();
         counter.addScore();
         getWorld().removeObject(this);
       }
       else if (getY() == 599)
       {
         World world = getWorld();
         MyWorld myWorld = (MyWorld)world;
         HealthBar healthbar = myWorld.getHealthbar();
         healthbar.loseHealth();
         healthbar.loseHealth();
         getWorld().removeObject(this);
       }
    }
    
}
