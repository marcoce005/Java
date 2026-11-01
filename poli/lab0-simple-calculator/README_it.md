# Lab0 - Calcolatrice semplice

L'obiettivo di questa esercitazione di laboratorio è imparare a utilizzare le operazioni di *git* e la procedura *gitflow*.

Tutte le operazioni di *git* descritte qui possono essere eseguite tramite l'interfaccia grafica oppure tramite l'interfaccia a riga di comando (CLI) fornita da un terminale.

### 1. Clonare un repository usando VSCode e git.

- ![](img/gitlab.svg) Su GitLab fare clic sul pulsante blu "`Code`" e poi su "`Clone with HTTPS`" &#x1F4CB; per copiare il link del repository
    - se si utilizza VSCode installato sul proprio computer, è possibile fare clic su `Visual Studio Code (HTTPS)`
- ![](img/vscode.svg) In VSCode clonare il repository:
    - Nella schermata di benvenuto selezionare "`Clone Git Repository...`"  
    oppure  
    [`Ctrl`] [&#x21e7;] [`P`] oppure [&#x2318;] [&#x21e7;] [`P`] per visualizzare la palette dei comandi, quindi scrivere *Clone* e selezionare *Git: Clone*
    - Inserire l'URL di questo repository, quello copiato da GitLab nel passaggio precedente
    - Selezionare una posizione nel file system
        - in Crownlabs usare `/vscode/workspace`, che viene conservata in caso di arresto anomalo
    - Inserire il proprio nome utente (ad es. s999999) e la password
    - Confermare di voler aprire il progetto

    oppure

    - &#x276F;_ `git clone https://git-oop.polito.it/s....`  
    l'url copiata in GitLab
    - aprire con VSCode la cartella del progetto


### 2. Creare una Merge Request con il relativo branch per R1

![](img/gitlab.svg) In GitLab, partendo da una Issue, creare una nuova Merge Request e il relativo Feature Branch:

- Nel menu a sinistra, selezionare *Plan > Work Items* per visualizzare l'elenco delle issue

    ![Issue in GitLab](img/IssueList.png)

- Aprire la issue #1 *"R1 - Add subtract operation"*, che è quella in fondo (sono in ordine inverso di creazione)

    ![Dettagli della issue in GitLab](img/IssueDetail.png)

- Fare clic sul pulsante '*Create merge request*' per creare una merge request in bozza con le impostazioni predefinite

    - quando richiesto, mantenere il nome predefinito per il branch (`1-r1-add-subract-operation`)

    ![Nuova Merge Request](img/NewMR.png)

- Controllare i dettagli e confermare la creazione della MR
    - assicurarsi che `Mark as draft` sia selezionato
    - è possibile aggiungere informazioni alla descrizione (mantenere la parte predefinita, perché contiene il collegamento alla Issue)
    - assegnare la issue (per i progetti con una sola persona fare clic su `Assign to me`)
    - assicurarsi che `Delete source branch...` **NON** sia selezionato
    - fare clic su `Create merge request`

    ![Nuova MR vuota](img/EmptyMR.png)

    Il risultato è una Merge Request in bozza associata a un nuovo branch nel repository

### 3. Implementare il codice per completare la MR

- ![](img/vscode.svg) In VSCode, prima di iniziare lo sviluppo, il repository locale deve essere aggiornato con un *Fetch*

    - Fare clic su ![](img/VSFetch.png) nella barra delle azioni di git:

    ![](img/VSGitGraph.png)

    - oppure, nel pannello Source Control, `...` > `Pull, Push` > `Fetch`

        - &#x276F;_ `git fetch`

- ![](img/vscode.svg) Passare al feature branch `1-r1-add-subtract-operation`

    - fare clic sul pulsante del branch nella barra inferiore ![Checkout](img/VSBranch_s.png)
    - quindi scegliere il feature branch dall'elenco dei branch disponibili: `origin/1-r1-add-subtract-operation`.

  oppure

    - nel pannello Source Control, `...` > `Checkout to...`  
    - quindi scegliere il feature branch dall'elenco dei branch disponibili: `origin/1-r1-add-subtract-operation`.

    oppure

    - &#x276F;_ `git switch 1-r1-add-subtract-operation`

&#9888;&#65039; Tutto lo sviluppo **DEVE** essere eseguito nel feature branch, non nel branch `main`!

- ![](img/vscode.svg) In VSCode completare il codice dell'applicazione
    - Deve eseguire le operazioni aritmetiche di base: addizione, sottrazione, moltiplicazione e divisione
    - La maggior parte del codice è già presente in `Calculator.java`; manca l'operazione di sottrazione

- ![](img/vscode.svg) In VSCode, fare clic sul pulsante Test a sinistra ![](img/TestBt.svg)
    - Espandere il contenuto fino a trovare `TestCalculator.java`
    - Fare clic sul pulsante di esecuzione &#x23F5; accanto al file
    - Se un test fallisce, compare una &#10006; rossa cerchiata; leggere il messaggio e correggere il programma.
      (la prima volta fallirà, poiché manca il codice della sottrazione)
    - Se i test hanno esito positivo, accanto ai test compare una &#10004; verde cerchiata

&#9888;&#65039; Procedere solo se tutti i test vengono superati.


### 4. Eseguire il commit e il push di tutti i file nel repository remoto

&#9888;&#65039; Se non si è mai usato git su proprio computer è necessario impostare le [informazioni sull'autore](#info-autore)

- ![](img/vscode.svg) In VSCode eseguire il commit e il push del codice
    - Fare clic sul pulsante Source Control ![](img/VersionControlBt.svg) per aprire il pannello Source Control
    - Verranno visualizzate le modifiche, incluso `Calculator.java` con una **M** sulla destra, a indicare che è stato **M**odificato
    - È possibile fare clic su `Calculator.java` per visualizzare le differenze
    - Aggiungere `Calculator.java` alle "Staged Changes" facendo clic sul **`+`** accanto al file
        - &#x276F;_   `git add src/calc/Calculator.java`
    - Inserire il messaggio di commit (ad es. "First Requirement") e fare clic sul pulsante "Commit"
        - &#x276F;_   `git commit --message "First Version"`
        
        &#9888;&#65039; Se si dimentica di inserire il messaggio di commit, viene aperto un editor in cui è possibile inserire il messaggio, salvarlo e fare clic sul segno di spunta in alto a destra per procedere
    - Fare clic sul pulsante `Sync Changes` per inviare le modifiche al repository remoto
        - &#x276F;_   `git push`

- ![](img/gitlab.svg) Su GitLab, la pagina web della Merge Request dovrebbe mostrare il nuovo commit e il risultato dei test.

    ![Test della MR superati](img/PassingMR.png)

### 5. Eseguire il merge della Merge Request


- ![](img/gitlab.svg) Su GitLab procedere con la Merge Request
    - Verificare che la pipeline sia stata superata (segno di spunta verde); in caso contrario, correggerla in VS Code ed eseguire il push della versione corretta
    - Contrassegnare la MR come *ready* facendo clic sul link `Mark as ready`; in questo modo compare il pulsante `Merge`

    - Assicurarsi di NON selezionare l'opzione *Delete source branch* 
    - Fare clic su `Merge`.


Di conseguenza, un nuovo merge commit viene aggiunto al branch di destinazione (`main`), la Merge Request risulta ![](img/Merged.png) e la Issue associata viene chiusa.

### 6. Lavorare su due feature branch paralleli

- ![](img/gitlab.svg) In GitLab, creare una Merge Request per entrambe le issue R2 e R3

    - Issue #2 *R2 - Move greeting*
    - Issue #3 *R3 - Exit with 0*

    Creare una Merge Request per entrambe

- ![](img/vscode.svg) implementare R2
    - Eseguire il fetch di tutti i branch remoti

    - Passare al feature branch `2-r2-move-greeting` 
    - Applicare la modifica richiesta, cioè spostare il saluto come richiesto da [R2](#r2---spostare-il-saluto)
    - Eseguire i test
    - Eseguire il commit e il push del codice

- ![](img/vscode.svg) implementare R3
    - Passare al feature branch `3-r3-exit-with-0` 
    - Apportare la modifica richiesta, cioè usare 0 per uscire come richiesto da [R3](#r3---uscire-con-0)
    - Eseguire i test
    - Eseguire il commit e il push del codice

- ![](img/gitlab.svg) In GitLab, eseguire il merge della prima MR:

    - Dal menu a sinistra, selezionare *Code* > *Merge Requests* e scegliere la MR *Resolve "R2 - Move greeting"*
    - Verificare che superi tutti i test
    - Contrassegnarla come *ready*
    - Fare clic su `Merge`

- ![](img/gitlab.svg) In GitLab, eseguire il merge della seconda MR:

    - Dal menu a sinistra, selezionare *Code* > *Merge Requests* e scegliere la MR *Resolve "R3 - Exit with 0"*
    - Verificare che superi tutti i test
    - Contrassegnarla come *ready*
    - Fare clic su `Merge`

&#x1F4AC; Poiché i due branch hanno modificato righe diverse (anche se nello stesso file), possono essere uniti senza problemi in qualsiasi ordine.

### 6. Lavorare su due branch paralleli in conflitto

Simuliamo ciò che accade quando due sviluppatori apportano contemporaneamente modifiche (in conflitto) alla stessa sezione di un file.

- ![](img/gitlab.svg) In GitLab, creare una Merge Request per entrambe le issue R4 e R5

    - Issue #4 *R4 - Kind*
    - Issue #5 *R5 - Precise*

    - Creare una Merge Request per entrambe

- ![](img/vscode.svg) In VSCode, implementare il requisito R4
    - Eseguire il fetch di tutti i branch remoti
    - Passare al feature branch `4-r4-kind`
    - Apportare la modifica richiesta, cioè aggiungere "Please" come richiesto da [R4](#r4---gentile)
    - Eseguire i test
    - Eseguire il commit e il push del codice
- ![](img/vscode.svg) In VSCode, implementare il requisito R5
    - Passare al feature branch `5-r5-precise`
    - Apportare la modifica richiesta, cioè usare il termine "operand" come richiesto da [R5](#r5---preciso)
    - Eseguire i test
    - Eseguire il commit e il push del codice

- ![](img/gitlab.svg) In GitLab, eseguire il merge della prima MR:

    - Dal menu a sinistra, selezionare *Code* > *Merge Requests* e scegliere la MR *Resolve "R4 - Kind"*
    - Verificare che superi tutti i test
    - Contrassegnarla come *ready*
    - Fare clic su `Merge`

- ![](img/gitlab.svg) In GitLab, osservare il conflitto che ora compare per la seconda MR:

    - Dal menu a sinistra, selezionare *Code* > *Merge Requests* e scegliere la MR *Resolve "R5 - Precise"*
    
        ![](img/MRConflict.png)

    - Fare clic sul link *Resolve Conflicts* per vedere come risolverlo online in GitLab:

        ![](img/MRResolveOnline.png)

      &#x1F4AC; Per conflitti molto semplici, questo è un modo rapido e facile per risolverli.
      Il problema è che non sono disponibili il controllo della sintassi né la possibilità di eseguire i test prima di effettuare il commit delle modifiche.

      &#9888; NON RISOLVERE QUESTO CONFLITTO ONLINE

    - Fare clic su `Cancel` per tornare alla pagina principale della MR.

- ![](img/vscode.svg) In VSCode, risolvere il conflitto combinando le due modifiche.

    - Eseguire il fetch di tutte le modifiche remote

        - &#x276F;_  `git fetch`

        Si osserva che il puntatore al main remoto (`origin/main`) viene aggiornato, mentre il branch `main` locale non lo è.

        ![](img/VSConflictGraph.png)

    - Passare a main ed eseguire il pull per aggiornare il branch `main` locale

        - &#x276F;_  `git switch main`
        - &#x276F;_  `git pull`

        ![](img/VSConflictGraphUp.png)

    - Tornare al branch `5-r5-precise`
        - &#x276F;_  `git switch 5-r5-precise`

    - Eseguire il merge di `main` in `5-r5-precise`
        - `...` > `Branch` > `Merge...`, quindi selezionare `main`
            - &#x276F;_  `git merge main`

            Il file in conflitto viene mostrato nella sezione *Merged Changes* del pannello Source Control

            ![](img/VSMergeChanges.png)

            Il conflitto è visibile anche nell'editor, racchiuso tra `<<<<<<< HEAD` e `>>>>>>> main`:

            ```java
            <<<<<<< HEAD (Current Change)
                in = IO.readln("Enter first operand: ");
                num1 = Double.parseDouble(in);
                in = IO.readln("Enter second operand: ");
            =======
                in = IO.readln("Please, enter first number: ");
                num1 = Double.parseDouble(in);
                in = IO.readln("Please, enter second number: ");
            >>>>>>> main (Incoming Change)        
            ```

    - Risolvere il conflitto nell'editor
        - In questo caso specifico, il modo più semplice consiste nel modificare una delle due alternative (*Current Change* o *Incoming Change*), incorporando le modifiche dell'altra, e poi accettarla

            Ad es.

            ```java
            <<<<<<< HEAD (Current Change)
                in = IO.readln("Please, enter first operand: ");
                num1 = Double.parseDouble(in);
                in = IO.readln("Please, enter second operand: ");
            =======
                in = IO.readln("Please, enter first number: ");
                num1 = Double.parseDouble(in);
                in = IO.readln("Please, enter second number: ");
            >>>>>>> main (Incoming Change)        
            ```

            Quindi fare clic su `Accept Current Change`

    - Confermare che il conflitto sia stato risolto
        - Fare clic sul `+` a destra del file `Calculator.java` nel pannello Source Control per aggiungerlo alle Staged Changes

        - &#x276F;_  `git add src/calc/Calculator.java`

    - Eseguire commit e push

        - &#x276F;_  `git merge --continue`
        - &#x276F;_  `git push`

- ![](img/gitlab.svg) In GitLab, verificare che il conflitto sia risolto e procedere con il merge
    - Verificare che superi tutti i test
    - Contrassegnarla come *ready*
    - Fare clic su `Merge`

---

# Impostazioni

## Info Autore

Quando si effettua un commit, Git aggiunge automaticamente le informazioni sull’autore del commit.

I casi possibili sono:

- Non hai mai utilizzato Git sul tuo computer: il primo commit non riesce perché sono necessari il nome e l’indirizzo e-mail dell’autore.

    Per risolvere il problema, apri un terminale ed esegui i seguenti comandi:

    ```sh
    git config --global user.email "s999999@studenti.polito.it"
    git config --global user.name "Tuo Nome"
    ```

    Questa operazione deve essere eseguita una sola volta sul computer.

- Hai già utilizzato Git con il tuo account personale (ad esempio GitHub): tale account viene utilizzato automaticamente.

    Puoi sovrascrivere l’account come mostrato sopra.

    In alternativa, puoi configurare un account soltanto per il progetto corrente:

    ```sh
    git config user.email "s999999@studenti.polito.it"
    git config user.name "Tuo Nome"
    ```

Per maggiori informazioni, consulta la [documentazione di Git Config](https://git-scm.com/docs/git-config#OPTIONS).

---

# Requisiti

## R1 - Aggiungere l'operazione di sottrazione

Il metodo `compute()` della classe `Calculator`, quando viene invocato con l'operazione `Calculator.SUB`, deve restituire la differenza tra il primo e il secondo operando.

Ad es.
```java
Calculator.compute(Calculator.SUB, 10, 8);
```

deve restituire `2.0`.


## R2 - Spostare il saluto

Spostare la stampa del saluto prima del ciclo dei comandi, in modo che il messaggio `"\nSimple Calculator"` venga stampato una sola volta all'avvio dell'applicazione e non prima di ogni comando.


## R3 - Uscire con 0

Impostare il valore del codice di uscita su `0`.

Modificare il codice e il relativo prompt.


## R4 - Gentile

Anteporre `"Please"` alla richiesta di un nuovo numero

Sostituire i due `"Enter first number"` e `"Enter second number"` con `"Please, enter first number"` e `"Please, enter second number"`.


## R5 - Preciso

Sostituire la richiesta di un `number` con la richiesta di un `operand`.

Sostituire i due `"Enter first number"` e `"Enter second number"` con `"Enter first operand"` e `"Enter second operand"`.


---
V 3.0.0.
