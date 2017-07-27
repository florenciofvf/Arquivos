package turma_android.com.br.arquivos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AreaDesenho area = new AreaDesenho(this);

        setContentView(area);

        area.desenhar();
    }
}
