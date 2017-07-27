package turma_android.com.br.arquivos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class AreaDesenho extends View implements Runnable {
    private Handler handler = new Handler();
    private Paint cor = new Paint();

    private int X = 50;
    private int Y = 50;
    private int x = 5;
    private int y = 5;
    private int d = 25;

    public AreaDesenho(Context context) {
        super(context);
        cor.setARGB(255, 0, 0, 0);
        cor.setAntiAlias(true);
    }

    public void desenhar() {
        handler.post(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(X, Y, d, cor);
    }

    @Override
    public void run() {
        movimentar();
        invalidate();
        handler.postDelayed(this, 3);
    }

    private void movimentar() {
        int largura = getWidth();
        int altura = getHeight();

        if(X <= 10 || X >= largura - d * 2) {
            x*= -1;
        }

        if(Y <= 10 || Y >= altura - d * 2) {
            y*= -1;
        }

        X+=x;
        Y+=y;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(0);
        float y = event.getY(0);

        X = (int) x;
        Y = (int) y;

        return true;
    }
}