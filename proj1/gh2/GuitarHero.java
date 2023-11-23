package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final double CONCERT = 440.0;
    public static final String KEY = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        GuitarString[] string = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            string[i] = new GuitarString(CONCERT * Math.pow(2, (i - 24.0) / 12.0));
        }
        int index = 0;

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                index = GuitarHero.KEY.indexOf(key);
                if (index != -1) {
                    string[index].pluck();
                }else {
                    index = 0;
                }

            }

            /* compute the superposition of samples */
            double sample = string[index].sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            string[index].tic();;
        }
    }
}

