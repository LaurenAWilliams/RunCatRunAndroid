package uk.co.lawilliams.finalproject.runcatrun.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import uk.co.lawilliams.finalproject.runcatrun.box2d.CatUserData;
import uk.co.lawilliams.finalproject.runcatrun.box2d.EnemyUserData;
import uk.co.lawilliams.finalproject.runcatrun.box2d.FloorUserData;
import uk.co.lawilliams.finalproject.runcatrun.enums.EnemyType;

/**
 * @author Lauren Williams, using tutorial by William Mora
 * @see [William Mora](http://williammora.com/a-running-game-with-libgdx-part-1)
 * <p>
 * Allows creation of physics objects and inserts them into the world
 */

public class WorldUtils {

    /**
     * @return new world, handling all physics entities
     */
    public static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }

    /**
     * @param world all physics entities etc.
     * @return a physics entity representing the ground
     */
    public static Body createFloor(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constants.FLOOR_X, Constants.FLOOR_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.FLOOR_WIDTH / 2, Constants.FLOOR_HEIGHT / 2);
        body.createFixture(shape, Constants.FLOOR_DENSITY);
        body.setUserData(new FloorUserData(Constants.FLOOR_WIDTH, Constants.FLOOR_HEIGHT));
        shape.dispose();
        return body;
    }

    /**
     * @param world all physics entities etc.
     * @return a physics entity representing the cat
     */
    public static Body createCat(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.CAT_X, Constants.CAT_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.CAT_WIDTH / 2, Constants.CAT_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.CAT_GRAVITY_SCALE);
        body.createFixture(shape, Constants.CAT_DENSITY);
        body.resetMassData();
        body.setUserData(new CatUserData(Constants.CAT_WIDTH, Constants.CAT_HEIGHT));
        shape.dispose();
        return body;
    }

    /**
     * @param world all physics entities etc.
     * @return a physics entity representing an enemy. Note: EnemyType is randomly generated.
     */
    public static Body createEnemy(World world) {
        EnemyType enemyType = RandomUtils.getRandomEnemyType();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(enemyType.getWidth() / 2, enemyType.getHeight() / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, enemyType.getDensity());
        body.resetMassData();
        EnemyUserData userData = new EnemyUserData(enemyType.getWidth(), enemyType.getHeight(), enemyType.getAnimationKey());
        body.setUserData(userData);
        shape.dispose();
        return body;
    }


}
