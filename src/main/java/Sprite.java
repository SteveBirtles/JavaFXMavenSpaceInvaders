import java.util.Set;
import java.util.Iterator;
import javafx.scene.image.*;

public class Sprite
{

    protected Image image;
    protected double x;
    protected double y;
    protected double dx;
    protected double dy;
    protected double r;
    protected boolean expired;

    public Sprite(double x, double y, double r, Image image)
    {
        this.x = x;
        this.y = y;
        this.image = image;
        this.r = r;
    }

    public void setVelocity(double dx, double dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public Image getImage()
    {
        return image;
    }

    public void update(double frameLength)
    {
        x += dx * frameLength;
        y += dy * frameLength;

        if (x < -100) x += Main.WINDOW_WIDTH + 200;
        if (y < -100) y += Main.WINDOW_HEIGHT + 200;
        if (x > 100 + Main.WINDOW_WIDTH) x -= Main.WINDOW_WIDTH + 200;
        if (y > 100 + Main.WINDOW_HEIGHT) y -= Main.WINDOW_HEIGHT + 200;

    }

    public static void clearUpExired(Set<Sprite> entities)
    {
        Iterator<Sprite> expiredEntityRemover = entities.iterator();
        while (expiredEntityRemover.hasNext()) {
            Sprite s = expiredEntityRemover.next();
            if (s.expired) expiredEntityRemover.remove();
        }
    }

    public boolean collidesWith(Sprite other)
    {
        if (Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2) < Math.pow(r + other.r, 2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}