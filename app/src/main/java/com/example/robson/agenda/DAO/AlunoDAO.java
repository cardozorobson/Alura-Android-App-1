package com.example.robson.agenda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.robson.agenda.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robson on 11/2/2017.
 */

public class AlunoDAO extends SQLiteOpenHelper {


    public AlunoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, site TEXT, nota REAL);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos;";

        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Aluno aluno) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoAluno(aluno);


        db.insert("Alunos", null, dados);
    }

    @NonNull
    private ContentValues pegaDadosDoAluno(Aluno aluno) {
        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("endereco", aluno.getEnd());
        dados.put("telefone", aluno.getFone());
        dados.put("site", aluno.getSite());
        dados.put("nota", aluno.getNota());
        return dados;
    }

    public List<Aluno> BuscaAlunos() {

        String sql = "SELECT * FROM Alunos";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Aluno> alunos = new ArrayList<Aluno>();

        while(c.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setSite(c.getString(c.getColumnIndex("site")));
            aluno.setNota(c.getDouble(c.getColumnIndex("nota")));
            aluno.setFone(c.getString(c.getColumnIndex("telefone")));
            aluno.setEnd(c.getString(c.getColumnIndex("endereco")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));

            alunos.add(aluno);
        }

        c.close();

        return alunos;

    }

    public void deletar(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {aluno.getId().toString()};

        db.delete("Alunos","id = ?", params);
    }

    public void altera(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoAluno(aluno);
        String [] params = {aluno.getId().toString()};
        db.update("Alunos",dados,"id = ?",params);

    }
}
