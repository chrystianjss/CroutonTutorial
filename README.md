![Crouton](/imgs_tutorial/img1.png?raw=true)
### Overview
O objetivo principal do **Crouton**, é ser uma uma alternativa mais amigável ao
tradicional TOAST do Android, oferecendo contexto customizado às diversas situações
em que há a necessidade de exibir uma notificação. A posição tradicional do **Crouton**
é o topo da tela, mas esta pode ser modificada a gosto do desenvolvedor. Também é
possível exibir multiplos **Croutons**, sendo assim exibidos um após o outro.

![Crouton Look](/imgs_tutorial/img2.png?raw=true)

### Baixando e configurando a Biblioteca

No Android Studio

O build requer o uso do Gradle. Os passo são os seguintes:

* Instalar o gradle
* gradle assemble fará o build dos artefatos
* gradle jar fará o build do jar

Após colocar o Crouton em um repositório você poderá adicionar as dependências
dele.

```sh
compile( 'de.keyboardsurfer.android.widget:crouton:1.8.5@aar' ) {
    exclude group : 'com.google.android' , module : 'support-v4'
}
```

No Eclipse

A biblioteca foi desenvolvida no ambiente do Android Studio e faz uso do Gradle. Apesar de não muito recomendado pelos desenvolvedores, existe a opção de baixar o
arquivo .jar da biblioteca para que possa ser usada no Eclipse.

Para baixar acesse o Repository Central do Maven e baixe o arquivo **crouton-1.8.5.
jar** http://search.maven.org/#browse%7C1688386235

Em seguida, coloque o .jar na pasta **libs** do seu projeto, e está pronta para usar.

### Usando o Crouton
O uso da API é tão simples como a do Toast:

**Criando um Crouton para um CharSequence**

    Crouton.makeText(Activity, CharSequence, Style).show();

**Criando um Crouton para uma String do resource da sua aplicação**

    Crouton.makeText(Activity, int, Style).show();
    
**Você também pode associar o Crouton a qualquer ViewGroup:**

    Crouton.makeText(Activity, int, Style, int).show();
    Crouton.makeText(Activity, int, Style, ViewGroup).show();
    
A chamada do método `Crouton.show(...)` irá disparar e exibir o seu Crouton.

Obs.: A chamada do método `Crouton.cancelAllCroutons();` é recomendada no
Activity.onDestroy() para que sejam cancelados quaisquer outros Croutons agendados.


###Exemplos

Há três estilos predefinidos no Crouton:


Todo o visual e customização do Crouton é definido pela classe **Style**.

Você pode fazer uso dos estilos **Style.ALERT**, **Style.CONFIRM** e **Style.INFO** ou definir o seu próprio estilo.

As opções de customização são:

* Tempo de exibição
* Dimensões
* Opções para o texto
* Views customizadas
* Animação ao aparecer e desaparecer
* Exibir imagem

Demonstração do uso da biblioteca Crouton
