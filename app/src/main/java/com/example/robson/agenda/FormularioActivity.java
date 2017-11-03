package com.example.robson.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.robson.agenda.DAO.AlunoDAO;
import com.example.robson.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        helper = new FormularioHelper(this);
        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        if(aluno != null){
            helper.preencheFormulario(aluno);
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_form_ok:


                Aluno aluno = helper.pegaAluno();
                AlunoDAO dao = new AlunoDAO(this);

                if(aluno.getNome().isEmpty() || aluno.getEnd().isEmpty() || aluno.getFone().isEmpty() || aluno.getSite().isEmpty()
                        || aluno.getNota() == 0){
                    Toast.makeText(FormularioActivity.this, "Preencha todos campos",Toast.LENGTH_SHORT).show();
                }else {

                    if(aluno.getId() != null){
                        dao.altera(aluno);
                        Toast.makeText(FormularioActivity.this, " Alterado com sucesso", Toast.LENGTH_SHORT).show();

                    }else {
                        dao.insere(aluno);
                        Toast.makeText(FormularioActivity.this, " Salvo com sucesso", Toast.LENGTH_SHORT).show();
                    }



                    dao.close();



                    finish();
                }
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
