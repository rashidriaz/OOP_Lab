/*
 *   Copyright (c) 2020 
 *   All rights reserved.
 */

import java.util.concurrent.TimeUnit;

/*
 *   Copyright (c) 2020 
 *   All rights reserved.
 */

public class Stream{
     public static void clearScreens(int time) throws InterruptedException {
          TimeUnit.SECONDS.sleep(time);
          System.out.print("\033\143");
     }
}