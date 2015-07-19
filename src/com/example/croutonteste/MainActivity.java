package com.example.croutonteste;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Aplicativo destinado a demonstrar a utilização
 * da biblioteca Crouton
 *
 * Este exemplo simula uma operação de login que exibirá 
 * uma mensagem diferente através do Crouton para cada tipo de evento (sucesso e falha)
 * durante a tentativa de acesso
 */
public class MainActivity extends Activity {

	final String nomeUsuario = "teste";
	final String senhaUsuario = "123456";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		final Button botaoLogin = (Button) findViewById(R.id.botao_login_entrar);
		botaoLogin.setOnClickListener(new View.OnClickListener() {
			 public void onClick(View v) {
				 EditText textNome = (EditText) findViewById(R.id.nome);
				 EditText textSenha = (EditText) findViewById(R.id.senha);
				 
				 checarLogin(textNome, textSenha);
			 }
		});
	}
	
	/**
	 * Método responsável por verificar a tentativa de login do usuário
	 * 
	 * @param nome - nome do usuário no sistema
	 * @param senha - senha do usuário no sistema
	 */
	public void checarLogin(EditText nome, EditText senha){
		String strNome = nome.getText().toString();
		String strSenha = senha.getText().toString();
		
		Crouton.clearCroutonsForActivity(this);
		
		if(strNome.equals(nomeUsuario) && strSenha.equals(senhaUsuario)){

			//Definindo estilo personalizado para a mensagem de sucesso
			Style style = new Style.Builder()
			.setBackgroundColor(android.R.color.holo_purple)
			.setGravity(Gravity.RIGHT)
		    .setHeight(106)
		    .build();
			
			 Crouton.makeText(this, "Usuário e senha corretos!", style).show();
		 } else {
			 Crouton.makeText(this, "Usuário ou senha incorreta!", Style.ALERT).show();
		 }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
