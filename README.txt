After Downloading and unzipping navigate to the dist folders for
both the client and the server to build, run and test.


➜  dist docker build -t myclient .
Sending build context to Docker daemon  52.74kB
Step 1/11 : FROM ubuntu
 ---> dd6f76d9cc90
Step 2/11 : RUN apt-get update
 ---> Using cache
 ---> e8fa4b3622a3
Step 3/11 : RUN apt-get install -y default-jre
 ---> Using cache
 ---> d61d0b221188
Step 4/11 : RUN apt-get install -y net-tools
 ---> Using cache
 ---> e8bc3561f130
Step 5/11 : COPY GenericNode.jar /
 ---> 95c7b483eebd
Step 6/11 : COPY entrypoint_client.sh /
 ---> b56574bd3620
Step 7/11 : COPY bigtest_tc.sh /
 ---> 3a5d2a9e45d2
Step 8/11 : COPY bigtest_rc.sh /
 ---> 5db67dab0ce4
Step 9/11 : COPY bigtest_uc.sh /
 ---> eaa705958576
Step 10/11 : ENTRYPOINT /entrypoint_client.sh
 ---> Running in aae913f85424
 ---> bbef607d477a
Removing intermediate container aae913f85424
Step 11/11 : CMD 300
 ---> Running in dff6bbb687d6
 ---> 52b92aafa8d5
Removing intermediate container dff6bbb687d6
Successfully built 52b92aafa8d5
Successfully tagged myclient:latest
➜  dist docker container ls -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                  PORTS               NAMES
5e37a9bfc8f0        myserver            "/runserver.sh"          11 minutes ago      Up 11 minutes                               pensive_benz
dcade0c3e4bd        toke/mosquitto      "docker-entrypoint..."   8 days ago          Exited (0) 7 days ago                       myMqtt
➜  dist docker run --rm -it myclient
TCSS558 Generic Client container up...
➜  dist

//In a second Terminal

➜  dist docker build -t myserver .
Sending build context to Docker daemon  17.41kB
Step 1/7 : FROM ubuntu
 ---> dd6f76d9cc90
Step 2/7 : RUN apt-get update
 ---> Using cache
 ---> e8fa4b3622a3
Step 3/7 : RUN apt-get install -y default-jre
 ---> Using cache
 ---> d61d0b221188
Step 4/7 : RUN apt-get install -y net-tools
 ---> Using cache
 ---> e8bc3561f130
Step 5/7 : COPY GenericNode.jar /
 ---> a2a7f3694bdc
Step 6/7 : COPY runserver.sh /
 ---> 13597d7c798e
Step 7/7 : ENTRYPOINT /runserver.sh
 ---> Running in 57d8f3811d42
 ---> c8c70398f3fe
Removing intermediate container 57d8f3811d42
Successfully built c8c70398f3fe
Successfully tagged myserver:latest
➜  dist docker container ls
CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS               NAMES
➜  dist docker run --rm -it myserver
server started at 1234
server stopped

//In a third terminal 
docker container inspect --format '{{ .NetworkSettings.IPAddress}}' <container name>
172.17.0.2 // this is servers Ip

//In a fourth Terminal
  ~ docker container ls -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                  PORTS               NAMES
51294f12987f        myclient            "/entrypoint_clien..."   6 seconds ago       Up 7 seconds                                jolly_shockley
5e37a9bfc8f0        myserver            "/runserver.sh"          11 minutes ago      Up 11 minutes                               pensive_benz
dcade0c3e4bd        toke/mosquitto      "docker-entrypoint..."   8 days ago          Exited (0) 7 days ago                       myMqtt
➜  ~ docker exec -it 5129 bash
root@51294f12987f:/# ls
GenericNode.jar  bin                   etc    media  root  sys
bigtest_rc.sh    boot                  home   mnt    run   tmp
bigtest_tc.sh    dev                   lib    opt    sbin  usr
bigtest_uc.sh    entrypoint_client.sh  lib64  proc   srv   var
root@51294f12987f:/# chmod u+x bigtest_tc.sh
root@51294f12987f:/# ls
GenericNode.jar  bin                   etc    media  root  sys
bigtest_rc.sh    boot                  home   mnt    run   tmp
bigtest_tc.sh    dev                   lib    opt    sbin  usr
bigtest_uc.sh    entrypoint_client.sh  lib64  proc   srv   var
root@51294f12987f:/# nano bigtest_tc.sh // In nano I changed the IP address
root@51294f12987f:/# ./bigtest_tc.sh
OK
Port: 1234 Action: PUT mD7=booLeejae8ne0lahgoos
OK
Port: 1234 Action: PUT 1VB=ahghukooy8ooYi7eeChe
OK
Port: 1234 Action: PUT 8CX=eK8zae6LaeTh2Niijeih
OK
Port: 1234 Action: PUT 5dZ=xoor5Yoidujechiebe7w
OK
Port: 1234 Action: PUT M6g=Uob5dahp3wo6xa9bah2h
OK
Port: 1234 Action: PUT 0Ml=hi3fieyaaMah7roo3the
OK
Port: 1234 Action: PUT m0J=gie0io0ekai0phian6Tu
OK
Port: 1234 Action: PUT eY8=aeM9leibaukae1shaeph
OK
Port: 1234 Action: PUT AJ4=oonie5FuNg0oab9zahfe
OK
Port: 1234 Action: PUT v9W=Oe6goht5aihaikeeshie
OK
Port: 1234 Action: PUT ahC4y=woh6ua7Aifeekeiroo7jiePaeLaic9aimoichaidue7AiPh
OK
Port: 1234 Action: PUT Pai4s=ahP6teeJeik8iem3eew3vio7Quafahlo9eezo7aez7ti3ao
OK
Port: 1234 Action: PUT Da3ei=booGhuthomohchohl5oongoovah8Poox3sahjutai0uphei
OK
Port: 1234 Action: PUT ohp6N=fig9iesum2Ke4aighaqu7loyoochuach5koo5einoo2she7
OK
Port: 1234 Action: PUT ou2Oi=Booghaith5liey2EirooYai2gohthaij2ZeibuuThojo2fo
OK
Port: 1234 Action: PUT ooH2a=uochoo6Geequoe9AGhoo8soh8uad4oohu6eehe3thien1fi
OK
Port: 1234 Action: PUT Ae8og=Thee1ohdie6ocaethi9epozobea3uo2zaerethae3iehube
OK
Port: 1234 Action: PUT ohY7V=ies5eingooh9mot2aetoovai2lie3oke0oiyahthaiX5zoz
OK
Port: 1234 Action: PUT ohL3g=thu4ni9oogh5ac4dexieLeegho9muu3oquaemahkaa5Eet8
OK
Port: 1234 Action: PUT AhCh8=aor2OYa4od9jaeph4eeGeexahng4Ha6hooboophi6ohnohw
OK
Port: 1234 Action: PUT nahZ0quu=tuGee9atisha4eikoh
OK
Port: 1234 Action: PUT aiC3sahR=aeNg6Umiemi5ahhu9U
OK
Port: 1234 Action: PUT hee0Woth=eig0eed4zung0HooF5
OK
Port: 1234 Action: PUT aeVieGh8=uHoh0oi7eeyaizaelo
OK
Port: 1234 Action: PUT aht3YaXa=ooco8Uxah9cohohTai
OK
Port: 1234 Action: PUT eeghe2Ze=pheiw7Ahneiseechee
OK
Port: 1234 Action: PUT Siesh6Al=oomashi4la4faeWahr
OK
Port: 1234 Action: PUT iehooSu8=iefiuquieBohv1aolu
OK
Port: 1234 Action: PUT ooZosh3d=peeHoush8eiphaishi
OK
Port: 1234 Action: PUT shaep6Hu=eb5axodau5aiCh7thi
OK
Port: 1234 Action: PUT HUH4=ichah9eeYae2wai7hei
OK
Port: 1234 Action: PUT P2UH=Eihai3Eighuquaeh4wo
OK
Port: 1234 Action: PUT B4mR=Iu8taighohFiengathe
OK
Port: 1234 Action: PUT 2F63=AeNga0oov0uuthoofit
OK
Port: 1234 Action: PUT D3nu=ooweemoo5biceis9oTa
OK
Port: 1234 Action: PUT zNu5=ye8oovooxo5vaiNat7g
OK
Port: 1234 Action: PUT DSA0=Beef6Iup9EiVeyah8ei
OK
Port: 1234 Action: PUT g6mZ=Jah5oos9qua4daeNgah
OK
Port: 1234 Action: PUT 2HmK=ooG3Un6oophooshi9Qu
OK
Port: 1234 Action: PUT O48i=EXae4eeGethaipaosoo
OK
Port: 1234 Action: PUT Mo6pi0Aig=Q3jZ
OK
Port: 1234 Action: PUT eedahJ7Aj=4j5X
OK
Port: 1234 Action: PUT OoFei2jao=95Zi
OK
Port: 1234 Action: PUT Oofe8aizi=9GyN
OK
Port: 1234 Action: PUT YeeYeNoo4=rAi6
OK
Port: 1234 Action: PUT eZia6rief=x9CE
OK
Port: 1234 Action: PUT bohhieV4a=sE0h
OK
Port: 1234 Action: PUT weevuon5G=6JwR
OK
Port: 1234 Action: PUT seed7Obae=l6Jn
OK
Port: 1234 Action: PUT iP7ri9al1=0nzV
OK
Port: 1234 Action: PUT Doh1thoiv=ing3uph0OoRaH3nae6eethienaivahw9teTheiJ
OK
Port: 1234 Action: PUT akae7iPh=Lai1eehaNgaw
OK
Port: 1234 Action: DELETE seed7Obae=null
OK
Port: 1234 Action: PUT ho9sie2Oc=ohmaaX1Itu8acahvii2eish0mohHaexaeXi5che
OK
Port: 1234 Action: DELETE eeghe2Ze=null
OK
Port: 1234 Action: PUT 44gQ=dooZ1aaB9aegohg9ahth6xezaish
OK
Port: 1234 Action: GET 5dZ=xoor5Yoidujechiebe7w
OK
Port: 1234 Action: DELETE weevuon5G=null
OK
Port: 1234 Action: GET Oofe8aizi=9GyN
OK
Port: 1234 Action: DELETE aeVieGh8=null
OK
Port: 1234 Action: DELETE ooZosh3d=null
OK
Port: 1234 Action: GET OoFei2jao=95Zi
OK
Port: 1234 Action: DELETE weevuon5G=null
OK
Port: 1234 Action: GET v9W=Oe6goht5aihaikeeshie
OK
Port: 1234 Action: GET ahC4y=woh6ua7Aifeekeiroo7jiePaeLaic9aimoichaidue7AiPh
OK
Port: 1234 Action: PUT OJ7ae=phie9chaoxohrohn7HaetaegeaR6jieVooCuepiecorofu6pha
OK
Port: 1234 Action: DELETE 0Ml=null
OK
Port: 1234 Action: GET Oofe8aizi=9GyN
OK
Port: 1234 Action: PUT lou1Aeph3=aelaif7ahqu4eeheLah2ohke2thohlee4eiYoH6
OK
Port: 1234 Action: GET eeghe2Ze=null
OK
Port: 1234 Action: PUT ePhi2fies=ahthu3oomaveepheiv6Quee7ierooYah1UShap4
OK
Port: 1234 Action: PUT Cee0ohth=zae1shookahK
OK
Port: 1234 Action: DELETE hee0Woth=null
OK
Port: 1234 Action: GET HUH4=ichah9eeYae2wai7hei
OK
Port: 1234 Action: DELETE v9W=null
OK
Port: 1234 Action: DELETE ahC4y=null
OK
Port: 1234 Action: PUT aeXee6Phi=gaex0Jeep3ooRu8weego1hu3odue4zaaghoof5e
OK
Port: 1234 Action: GET iP7ri9al1=0nzV
OK
Port: 1234 Action: GET HUH4=ichah9eeYae2wai7hei
OK
Port: 1234 Action: GET Oofe8aizi=9GyN
OK
Port: 1234 Action: GET shaep6Hu=eb5axodau5aiCh7thi
OK
Port: 1234 Action: GET 2F63=AeNga0oov0uuthoofit
OK
Port: 1234 Action: PUT JAx5=feineetae9peeDahThuox0Oj6eip
OK
Port: 1234 Action: GET Mo6pi0Aig=Q3jZ
OK
Port: 1234 Action: GET 8CX=eK8zae6LaeTh2Niijeih
OK
Port: 1234 Action: GET Ae8og=Thee1ohdie6ocaethi9epozobea3uo2zaerethae3iehube
OK
Port: 1234 Action: PUT Ki5aefie=thoh3Ou5oof9
OK
Port: 1234 Action: GET M6g=Uob5dahp3wo6xa9bah2h
OK
Port: 1234 Action: GET shaep6Hu=eb5axodau5aiCh7thi
OK
Port: 1234 Action: GET Oofe8aizi=9GyN
OK
Port: 1234 Action: GET iehooSu8=iefiuquieBohv1aolu
OK
Port: 1234 Action: PUT eoY4p=baimohneephu5opieyae9eihio8leeniuPuhuBohw5daiFaeze
OK
Port: 1234 Action: PUT aQuoh6aed=aechooqu5aefuiz8Hea1uheecaiBequ2Iesohyi
OK
Port: 1234 Action: GET AhCh8=aor2OYa4od9jaeph4eeGeexahng4Ha6hooboophi6ohnohw
OK
Port: 1234 Action: PUT Aoth8wiu8=teigahz9aphei2eN4chapaecahthaizohghumao
OK
Port: 1234 Action: GET 5dZ=xoor5Yoidujechiebe7w
OK
Port: 1234 Action: GET eeghe2Ze=null
OK
Port: 1234 Action: PUT bx8N=eeHahquiox3gei8fe7oothiey2oh
OK
Port: 1234 Action: GET hee0Woth=null
OK
Port: 1234 Action: PUT pxK8=meeciM5beuv9ahyiuh7eengiSoo9
OK
Port: 1234 Action: GET O48i=EXae4eeGethaipaosoo
OK
Port: 1234 Action: GET OoFei2jao=95Zi
OK
Port: 1234 Action: PUT aoDo1=leeGi4ahy8fe2Eing1leeChib6eiR0Ofachah9butuuvaenuix
OK
Port: 1234 Action: GET hee0Woth=null
OK
Port: 1234 Action: GET aiC3sahR=aeNg6Umiemi5ahhu9U
OK
Port: 1234 Action: GET shaep6Hu=eb5axodau5aiCh7thi
OK
Port: 1234 Action: GET ahC4y=null
OK
Port: 1234 Action: GET shaep6Hu=eb5axodau5aiCh7thi
OK
Port: 1234 Action: GET ooZosh3d=null
OK
Port: 1234 Action: GET OoFei2jao=95Zi
OK
Port: 1234 Action: PUT ie1Ae=iecoquo7ohFoongaK7ain4mauGieChei1poo2eeBi2koitaiga
OK
Port: 1234 Action: PUT eum4uoZa3=thoghuroojeiquaicagaeJ7aebohbec2ighahjo
OK
Port: 1234 Action: PUT eiCh5=wootahhu8xeo5thooKoo7Iphijeejoo0Keiz8AhNgousiepofu
OK
Port: 1234 Action: GET weevuon5G=null
OK
Port: 1234 Action: GET Pai4s=ahP6teeJeik8iem3eew3vio7Quafahlo9eezo7aez7ti3ao
OK
Port: 1234 Action: GET YeeYeNoo4=rAi6
OK
Port: 1234 Action: GET AJ4=oonie5FuNg0oab9zahfe
OK
Port: 1234 Action: GET M6g=Uob5dahp3wo6xa9bah2h
OK
Port: 1234 Action: GET aeVieGh8=null
OK
Port: 1234 Action: GET iP7ri9al1=0nzV
OK
Port: 1234 Action: GET AhCh8=aor2OYa4od9jaeph4eeGeexahng4Ha6hooboophi6ohnohw
OK
Port: 1234 Action: PUT Phoh2=fai3eihee2TahY4mei4iiraXaiquohsh4ChoJeowiepeeleedo
OK
Port: 1234 Action: PUT ieThej4li=soochoe7uNg4phiengoh7fuTh3koowohluM5uku
OK
Port: 1234 Action: GET HUH4=ichah9eeYae2wai7hei
OK
Port: 1234 Action: GET ahC4y=null
OK
Port: 1234 Action: GET eZia6rief=x9CE
OK
Port: 1234 Action: GET 1VB=ahghukooy8ooYi7eeChe
OK
Port: 1234 Action: GET 1VB=ahghukooy8ooYi7eeChe
OK
Port: 1234 Action: PUT lou1Aeph3=aelaif7ahqu4eeheLah2ohke2thohlee4eiYoH6
OK
Port: 1234 Action: GET 2F63=AeNga0oov0uuthoofit
OK
Port: 1234 Action: PUT Ahlai1kah9du=EVezuotai6sooview5
OK
Port: 1234 Action: GET Ae8og=Thee1ohdie6ocaethi9epozobea3uo2zaerethae3iehube
OK
Port: 1234 Action: PUT poo6aVoo=shahch5viZ2U
OK
Port: 1234 Action: GET ohp6N=fig9iesum2Ke4aighaqu7loyoochuach5koo5einoo2she7
OK
Port: 1234 Action: GET bohhieV4a=sE0h
OK
Port: 1234 Action: PUT wi4Miebe=sooF4Phae1ae
OK
Port: 1234 Action: PUT akae7iPh=Lai1eehaNgaw
OK
Port: 1234 Action: GET M6g=Uob5dahp3wo6xa9bah2h
OK
Port: 1234 Action: GET eeghe2Ze=null
OK
Port: 1234 Action: PUT eeW8oPec=mieGo6ue0Uuw
OK
Port: 1234 Action: GET Mo6pi0Aig=Q3jZ
OK
Port: 1234 Action: GET ooZosh3d=null
OK
Port: 1234 Action: GET v9W=null
OK
Port: 1234 Action: GET ahC4y=null
OK
Port: 1234 Action: GET Da3ei=booGhuthomohchohl5oongoovah8Poox3sahjutai0uphei
OK
Port: 1234 Action: GET DSA0=Beef6Iup9EiVeyah8ei
OK
Port: 1234 Action: PUT Jee1phoo=jahH8aeh7loh
OK
Port: 1234 Action: GET eZia6rief=x9CE
OK
Port: 1234 Action: GET 2HmK=ooG3Un6oophooshi9Qu
OK
Port: 1234 Action: PUT Du9ruKiek=laidie4ieShiquoh7ahGhahfuJu5TaeThaiDooc
root@51294f12987f:/# java -jar GenericNode.jar tc 172.17.0.2 1234 store
OK
Port: 1234 Action: GET ohp6N=fig9iesum2Ke4aighaqu7loyoochuach5koo5einoo2she7 iP7ri9al1=0nzV 2F63=AeNga0oov0uuthoofit eedahJ7Aj=4j5X nahZ0quu=tuGee9atisha4eikoh Cee0ohth=zae1shookahK Ae8og=Thee1ohdie6ocaethi9epozobea3uo2zaerethae3iehube wi4Miebe=sooF4Phae1ae O48i=EXae4eeGethaipaosoo aht3YaXa=ooco8Uxah9cohohTai ePhi2fies=ahthu3oomaveepheiv6Quee7ierooYah1UShap4 JAx5=feineetae9peeDahThuox0Oj6eip ieThej4li=soochoe7uNg4phiengoh7fuTh3koowohluM5uku ooH2a=uochoo6Geequoe9AGhoo8soh8uad4oohu6eehe3thien1fi Ki5aefie=thoh3Ou5oof9 HUH4=ichah9eeYae2wai7hei OJ7ae=phie9chaoxohrohn7HaetaegeaR6jieVooCuepiecorofu6pha 1VB=ahghukooy8ooYi7eeChe mD7=booLeejae8ne0lahgoos Pai4s=ahP6teeJeik8iem3eew3vio7Quafahlo9eezo7aez7ti3ao lou1Aeph3=aelaif7ahqu4eeheLah2ohke2thohlee4eiYoH6 eY8=aeM9leibaukae1shaeph Oofe8aizi=9GyN eoY4p=baimohneephu5opieyae9eihio8leeniuPuhuBohw5daiFaeze aiC3sahR=aeNg6Umiemi5ahhu9U B4mR=Iu8taighohFiengathe AJ4=oonie5FuNg0oab9zahfe ohL3g=thu4ni9oogh5ac4dexieLeegho9muu3oquaemahkaa5Eet8 Ahlai1kah9du=EVezuotai6sooview5 8CX=eK8zae6LaeTh2Niijeih Da3ei=booGhuthomohchohl5oongoovah8Poox3sahjutai0uphei bohhieV4a=sE0h iehooSu8=iefiuquieBohv1aolu Doh1thoiv=ing3uph0OoRaH3nae6eethienaivahw9teTheiJ bx8N=eeHahquiox3gei8fe7oothiey2oh 2HmK=ooG3Un6oophooshi9Qu akae7iPh=Lai1eehaNgaw aeXee6Phi=gaex0Jeep3ooRu8weego1hu3odue4zaaghoof5e m0J=gie0io0ekai0phian6Tu zNu5=ye8oovooxo5vaiNat7g eZia6rief=x9CE P2UH=Eihai3Eighuquaeh4wo 44gQ=dooZ1aaB9aegohg9ahth6xezaish ohY7V=ies5eingooh9mot2aetoovai2lie3oke0oiyahthaiX5zoz g6mZ=Jah5oos9qua4daeNgah ou2Oi=Booghaith5liey2EirooYai2gohthaij2ZeibuuThojo2fo shaep6Hu=eb5axodau5aiCh7thi Mo6pi0Aig=Q3jZ YeeYeNoo4=rAi6 pxK8=meeciM5beuv9ahyiuh7eengiSoo9 AhCh8=aor2OYa4od9jaeph4eeGeexahng4Ha6hooboophi6ohnohw D3nu=ooweemoo5biceis9oTa eum4uoZa3=thoghuroojeiquaicagaeJ7aebohbec2ighahjo eeW8oPec=mieGo6ue0Uuw 5dZ=xoor5Yoidujechiebe7w aQuoh6aed=aechooqu5aefuiz8Hea1uheecaiBequ2Iesohyi eiCh5=wootahhu8xeo5thooKoo7Iphijeejoo0Keiz8AhNgousiepofu ho9sie2Oc=ohmaaX1Itu8acahvii2eish0mohHaexaeXi5che ie1Ae=iecoquo7ohFoongaK7ain4mauGieChei1poo2eeBi2koitaiga Siesh6Al=oomashi4la4faeWahr Aoth8wiu8=teigahz9aphei2eN4chapaecahthaizohghumao aoDo1=leeGi4ahy8fe2Eing1leeChib6eiR0Ofachah9butuuvaenuix Jee1phoo=jahH8aeh7loh Du9ruKiek=laidie4ieShiquoh7ahGhahfuJu5TaeThaiDooc Phoh2=fai3eihee2TahY4mei4iiraXaiquohsh4ChoJeowiepeeleedo poo6aVoo=shahch5viZ2U DSA0=Beef6Iup9EiVeyah8ei OoFei2jao=95Zi M6g=Uob5dahp3wo6xa9bah2h
root@51294f12987f:/# java -jar GenericNode.jar tc 172.17.0.2 1234 exit
OK
Port: 1234 Action: GET  Sever stop..
root@51294f12987f:/# touch stop
root@51294f12987f:/# %                                                          ➜  ~