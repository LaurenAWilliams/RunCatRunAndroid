package uk.co.lawilliams.finalproject.runcatrun.utils;

import java.util.Random;

import uk.co.lawilliams.finalproject.runcatrun.enums.EnemyType;

/**
 * @author trashgod
 * @see [Stack Overflow](http://stackoverflow.com/a/1973018)
 * <p>
 * Allows random generation of EnemyType enums
 */

class RandomUtils {

    /**
     * @return random enemytype generated
     */
    static EnemyType getRandomEnemyType() {
        RandomEnum<EnemyType> randomEnemyType = new RandomEnum<EnemyType>(EnemyType.class);
        return randomEnemyType.random();
    }

    /**
     * @param <E> child class of Enum
     */
    private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] VALUES;

        RandomEnum(Class<E> token) {
            VALUES = token.getEnumConstants();
        }

        E random() {
            return VALUES[RND.nextInt(VALUES.length)];
        }
    }


}
