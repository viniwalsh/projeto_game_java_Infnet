import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
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
         World world = getWorld();
         MyWorld myWorld = (MyWorld)world;
         Counter counter = myWorld.getCounter();
         counter.addScore();
         getWorld().removeObject(this);
       }
       else if (getY() == 599)
       {
         World world = getWorld();
         MyWorld myWorld = (MyWorld)world;
         HealthBar healthbar = myWorld.getHealthbar();
         healthbar.loseHealth();
         getWorld().removeObject(this);
       }
    }
    
}
