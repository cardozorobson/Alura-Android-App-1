package com.example.robson.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.robson.agenda.modelo.Aluno;

/**
 * Created by Robson on 11/2/2017.
 */

public class FormularioHelper {


    private final EditText campoNome;
    private final EditText campoEnd;
    private final EditText campoFone;
    private final EditText campoSite;
    private final RatingBar campoNota;
    private Aluno aluno;


    public FormularioHelper(FormularioActivity fomularioActivity) {

        campoNome = (EditText) fomularioActivity.findViewById(R.id.form_nome);
        campoEnd = (EditText) fomularioActivity.findViewById(R.id.form_address);
        campoFone = (EditText) fomularioActivity.findViewById(R.id.form_phone);
        campoSite = (EditText) fomularioActivity.findViewById(R.id.form_site);
        campoNota = (RatingBar) fomularioActivity.findViewById(R.id.form_nota);
        aluno = new Aluno();
    }

    public Aluno pegaAluno() {


        aluno.setNome(campoNome.getText().toString());
        aluno.setEnd(campoEnd.getText().toString());
        aluno.setFone(campoFone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {

        campoNome.setText(aluno.getNome());
        campoEnd.setText(aluno.getEnd());
        campoFone.setText(aluno.getFone());
        campoSite.setText(aluno.getSite());

        campoNota.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;
    }

}