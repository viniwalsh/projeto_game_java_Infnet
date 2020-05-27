import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    int timesHit = 10;
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
            for (int i = 0; i < 10; i++) {
                healthbar.loseHealth();
            }        
         getWorld().removeObject(this);
       }
    }
}
