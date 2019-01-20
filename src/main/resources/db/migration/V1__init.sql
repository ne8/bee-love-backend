-- noinspection SqlNoDataSourceInspectionForFile

CREATE SCHEMA IF NOT EXISTS beelove;

CREATE TABLE IF NOT EXISTS beelove.banner (
  id       serial PRIMARY KEY,
  title    VARCHAR(255) NOT NULL,
  subtitle VARCHAR(255) NOT NULL
);

--
CREATE TABLE IF NOT EXISTS beelove.posts (
  id      serial PRIMARY KEY,
  title   VARCHAR(255) NOT NULL,
  content TEXT
);
--
CREATE TABLE IF NOT EXISTS beelove.products (
  id          serial PRIMARY KEY,
  name        VARCHAR(255) NOT NULL,
  price       FLOAT        NOT NULL,
  quantity    INTEGER      NOT NULL DEFAULT 1,
  pathToImage varchar(500),
  description TEXT
);

CREATE TABLE IF NOT EXISTS beelove.slider (
  id            serial PRIMARY KEY,
  imageLocation VARCHAR(255) NOT NULL,
  alt           VARCHAR(255) NOT NULL,
  title         VARCHAR(255) NOT NULL,
  description   VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS beelove.aboutus (
  id            serial PRIMARY KEY,
  imageLocation VARCHAR(255) NOT NULL,
  alt           VARCHAR(255) NOT NULL,
  subtitle      VARCHAR(255) NOT NULL,
  text          TEXT
);

CREATE TABLE IF NOT EXISTS beelove.orders(
    id            serial PRIMARY KEY,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    email_address VARCHAR(255) NOT NULL,
    city          VARCHAR(255) NOT NULL,
    postal_code   VARCHAR(255) NOT NULL,
    phone_number  VARCHAR(255) NOT NULL,
    full_address  VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS beelove.product_orders(
    id            serial PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    quantity       VARCHAR(255) NOT NULL,
    order_id      VARCHAR(255)
);

-- --
CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1;

--aboutUs INITIALIZATION
INSERT INTO beelove.aboutus (imageLocation, alt, subtitle, text)
VALUES ('assets/images/about-us/bee-keeper.png',
        'Bee Keeper',
        'Beekeeper Honey',
        'Professional beekeepers take agreat care of the farm and monitor all processes to gather honey in time.');
INSERT INTO beelove.aboutus (imageLocation, alt, subtitle, text)
VALUES ('assets/images/about-us/bee-garden.png',
        'Bee Garden',
        'Bee Garden',
        'We have built a tru cosy garden where our hard working bees produce all sorts of local honey and nectars.');
INSERT INTO beelove.aboutus (imageLocation, alt, subtitle, text)
VALUES ('assets/images/about-us/bee-products.png',
        'Bee Products',
        'Bee Products',
        'Our products are 100% organic, produced on a farm with natural ingredients addition only. Sweet & delicious.');

-- SLIDER INITIALIZATION
INSERT INTO beelove.slider (imageLocation, alt, title, description)
VALUES ('assets/images/slides/slides_1.jpg',
        'Straight from the hive',
        'Straight *from* the *hive*',
        'Discover the natural wonders of honey');
INSERT INTO beelove.slider (imageLocation, alt, title, description)
VALUES ('assets/images/slides/slides_2.jpg',
        'Local raw honey',
        'Local *raw* honey',
        'Honey has a multitude of benefits');
INSERT INTO beelove.slider (imageLocation, alt, title, description)
VALUES ('assets/images/slides/slides_3.jpg',
        'Honey''s natural benefits',
        'Honey''s *natural* benefits',
        'Our honey is never cooked');

-- BANNER INITIALIZATION
INSERT INTO beelove.banner (title, subtitle)
VALUES ('Our Honey Is Never Cooked, It Is Always Raw', 'TO PRESERVE FLAVOR AND HEALTH BENEFITS');
--
INSERT INTO beelove.posts (title, content)
VALUES ('Mierea și sugarii',
        '<p>Bacteria, Clostridium botulinum, este foarte comună în natură și orice hrană crudă, inclusiv miere, poate conține spori Clostridium botulinum. </p> <p>Un sistem digestiv complet dezvoltat va proteja o persoană împotriva ingerării C. botulinum. Cu toate acestea, sistemul digestiv al unui copil sub vârsta de 12 luni nu este pe deplin dezvoltat și, prin urmare, nu poate face față multor tipuri de antigeni, inclusiv C. botulinum. Toxinele produse de C. botulinum sunt extrem de periculoase și prezintă o condiție foarte gravă pentru sugari.<p/> <p>Mierea este o hrană neprelucrată și NU este recomandată pentru sugari cu vârsta mai mică de 12 luni. Este extrem de rar să găsească C. botulinum în miere, dar în ultimii 40 de ani a existat o mână plină de cazuri documentate. În aceste cazuri, se crede că bacteria a intrat în contact cu mierea undeva în timpul procesării mierii. <p/><p>Datorită proprietăților bacteriostatice ale mierii, bacteriile, inclusiv C. botulinum, nu vor crește și nu vor produce toxine în miere! Sporii botulinici sunt foarte rezilienți și pot rezista la condiții dure, inclusiv la procesul de pasteurizare a mierii. Dacă un copil ar ingera miere contaminată cu spori de C. botulinum, mierea s-ar dilua în tractul intestinal al sugarului, iar sporii ar avea condiții adecvate pentru a fi activate, asigurând astfel condițiile pentru botulism.</p>');

-- POSTS INITIALIZATION
INSERT INTO beelove.posts (title, content)
VALUES ('Stocarea mierii',
        '<p>Mierea este un produs alimentar foarte robust și, dacă este depozitat corespunzător, va dura ani, dacă nu zeci de ani. De fapt, mierea a fost găsită perfect conservată în mormintele faraonilor din Egipt.<p/><p> Calitatea mierii poate fi afectată de următorii factori: <p/> <strong>Umiditate excesivă</strong> <p/> <p>În  mod  ideal, conținutul de umiditate al mierei ar trebui să fie mai mic de 17,8%. Dacă conținutul de umiditate este prea mare, să zicem mai mult de 20%, mierea poate  fermenta din cauza drojdiilor din miere. Deoarece mierea este higroscopică, dacă nu este într-un recipient etanș, va atrage umezeală din aer.<p/><p><strong>Caldura excesiva</strong> </p>Mierea pierde multe din beneficiile sale pentru sănătate, prin combinarea căldurii și a timpului. <p/> Următoarea regulă este  foarte importanta,  de depozitare în timp ce temperatura păstrează majoritatea beneficiilor sale pentru sănătate: <br/>40 ° C timp de 30 de zile<br/> 30 ° C timp de 6 luni<br/> 20 C timp de 4 ani<br/>10 C timp de 35 de ani<br/> <p><strong>Expunere prelungită la lumina soarelui</strong></p> <p>Mierea pierde multe dintre beneficiile sale pentru sănătate cu expunere prelungită la lumina soarelui.</p> <p><strong>Elemente nocive în mediul său</strong></p> <p>Mierea este higroscopică și preia mirosurile din mediul său. Este, de asemenea, acida,  astfel încât poate dizolva metalul dacă este depozitat în recipiente metalice.</p>');
-- --
INSERT INTO beelove.posts (title, content)
VALUES ('Cum să descristalizați mierea.',
        '<p> Mierea care a început să cristalizeze, caracterizata prin cristale de glucoză formate pe fundul recipientului, pot fi ușor topite. Pur și simplu puneți recipientul de miere (cu capacul deschis) într-o baie de apă caldă la aproximativ 45 ° C timp de câteva ore sau după cum este necesar. Amestecarea mierei sau răsturnarea ocazional a recipientului pentru a sparge cristalele va accelera procesul.</p>');
-- --
INSERT INTO beelove.posts (title, content)
VALUES ('Cristalizarea mierei',
        '<p>Cristalizarea mierii reprezinta  formarea de cristale de glucoză monohidrata dintr-o soluție de zahăr super-saturată</p><p>Rata de cristalizare crește cu:</p><ul><li>Conținut redus de apă</li><li>Conținut mai mare de glucoză</li><li>Prezența particulelor solide (de exemplu, boabe de polen și cristale de miere)</li><li>Temperatura apropiată de 14 ° C (Temperaturi peste 28 ° C și sub 5 ° C rezultă în cristalizare foarte lentă)</li><li>Agitarea</li></ul><p>Rețineți că cristalizarea mai lentă produce cristale mai mari și mai neregulate.</p> <p>Cristalizarea mierii este complet normală și nu dăunează mierii. În cele mai multe cazuri, procesul de cristalizare poate fi inversat prin încălzirea ușoară a mierei pentru a "topi" cristalele.</p>');
-- --
INSERT INTO beelove.posts (title, content)
VALUES ('Compoziția medie a mierei',
        '<p>Mierea este în principal fructoză (38%), glucoză (31%), apă (17%), maltoză (7%) și cantități mici de trisaccharide, alți carbohidrați mai mari, zaharoză, minerale, vitamine și enzime.</p>');
-- --
INSERT INTO beelove.posts (title, content)
VALUES ('Compoziția medie a mierei',
        '<p>Mierea este în principal fructoză (38%), glucoză (31%), apă (17%), maltoză (7%) și cantități mici de trisaccharide, alți carbohidrați mai mari, zaharoză, minerale, vitamine și enzime.</p>');
-- --
INSERT INTO beelove.posts (title, content)
VALUES ('Soiuri de miere',
        '<p>Aroma, culoarea, textura și aroma mierii depind de plantele de la care albinele le-au adunat nectar. Miere de flori  făcută cu  nectarul din flori de afine, are culoarea chihlimbar închis și are un zahăr brun după gust. Miere de flori de zmeura este de culoare extra lumina, cu un gust slab de fructe, iar mierea de hrișcă este aproape neagră în culoare, cu un miros plin de gust și aromă. În general, o miere întunecată va avea un conținut nutrițional  mai  mare decât o miere transparenta.</p><p>Există sute de plante înfloritoare în  lume care produc nectar, oferind astfel posibilitatea de a avea sute de tipuri de miere. Mistrii de flori sălbatice reprezintă un amestec de plante cu flori și variază în funcție de culoare și de aromă, în funcție de regiune și de sezon.</p> <p><strong>Miere crudă</strong></p> <p>Se extrage și se curăță cu ajutorul unui vas de decantare la temperatura camerei. Conține aproape toată bunătatea pe care natura o pune în miere. Se granulează rapid și se poate separa în borcan cu fructoză lichidă pe partea superioară și glucoză granulată pe fund.</p><p><strong>Liquid Money - Filtrată la temperature camerei</strong></p><p>Extras și curățata utilizând un filtru de 50 microni. Mierea este încălzită la aceeași temperatură în interiorul unui stup într-o zi fierbinte. Conține o mare parte din bunătatea pe care natura o pune în miere. Va granula în două până la șase luni, în funcție de tipul de flori pe care albinele le-au vizitat pentru a aduna mierea.</p><p><strong>Crema de miere</strong></p><p>Mierea cremă este făcută din miere lichidă pură printr-un proces de cristalizare controlată pentru a produce cristale uniforme foarte fine, rezultând astfel o consistență cremoasă netedă. Mierea cremată nu are nimic adăugat și are aceeași valoare nutritivă ca și omologul său lichid.</p><p><strong>Miere pasteurizată lichidă</strong></p><p>A fost extras și curățat utilizând încălzirea blițului la o temperatură ridicată, super-filtrat printr-un filtru de 1 până la 5 microni și răcit rapid. Pierde o mare parte din bunătatea pe care o oferă natura, dar va dura peste 9 luni pe raftul magazinului fără granulare.</p><p><strong>Prelucrarea mierii</strong></p> <p>Honeycomb gata să mănânce! Cu mulți ani în urmă, apicultorii au zdrobit fagure de miere pentru a obține miere lichidă! Această metodă de prelucrare a mierii produce mai puțină miere pentru apicultor, deoarece forțează albinele să-și petreacă timpul și resursele, construind fagurele, în loc să facă mai multă miere. Albine consumă 7 kilograme de miere pentru a produce 1 kilogram de ceară de albine. Apariția extractorului centrifugal a permis apicultorilor să "zgâraie" sau să "despice" un strat subțire de ceară de pe suprafața fagurelui și să scoata mierea prin forța centrifugală. Integritatea fagurelui este menținută, iar albinele au mult mai puțin de lucrat pentru a repara eventualele fisuri sau puncte slabe din fagure. </p> <p>Întregul fagure de miere este disponibil pentru persoanele care doresc să se bucure de miere complet neatinse de mâinile omului. Ceara se va dizolva dacă este mestecată timp de aproximativ 15 minute, dar majoritatea oamenilor elimină ceara mestecată.</p> <p>Marea majoritate a oamenilor preferă mierea lichidă, deci extractoarele sunt folosite pentru a îndepărta mierea din fagure. Mierea proaspăt extrasă conține bucăți de ceară și parti din  albine. Mierea poate fi curățată permițându-i să se așeze într-un rezervor de menținere timp de o zi sau două sau prin pomparea acestuia printr-un filtru.</p>');
-- --
-- --
INSERT INTO beelove.posts (title, content)
VALUES ('Cum se produce mierea ?',
        '<p>Nectarul este de 80 până la 95 procente apă și 5 până la 20 procente zaharoză (zahăr de masă). Pe măsură ce albina transportă nectarul înapoi în stup, o enzimă proteică din stomacul albinei, numită invertază, rupe zaharoza în două zaharuri simple, fructoza și glucoza.</p> <p>Tinerele albine din stup,  elimina apa din solutia de zahar folosind doua metode. Ele trec nectarul de la albina la albina și "beau" apa din nectar, absorbind-o prin peretele din stomacul lor. De asemenea, ele creează fluxul de căldură și aerul în stup prin vibrarea aripilor, evaporând astfel apa din nectarul stocat în celule deschise.</p> <p>Atunci când cea mai mare parte a zaharozei a fost transformată în fructoză și glucoză și suficientă apă a fost eliminata din amestec pentru a o aduce la aproximativ 17,8% conținut de apă, avem un amestec delicios delicat, numit miere!</p> <p>După ce se face mierea, albinele se acoperă cu ceară de albine pentru a menține conținutul scăzut de umiditate.</p>');
-- --
-- --
-- products
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Crema hidratanta cu propolis',
        20,
        1,
        'assets/images/products/crema-hidratanta-propoplis.jpg',
        'Este un bun stimulator al refacerii tesuturilor afectate de rani, degeneratoru, taieturi si mai ales, arsuri');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Laptisor de matca pur',
        30,
        1,
        'assets/images/products/laptisor-de-matca-pur-crud.jpg',
        'Ca aliment si remediu natural cu efect profilactic, laptisorul de matca actioneaza preventiv, prin faptul ca ofera organismului' ||
         'cele mai importante substante nutritive de care are nevoie de care duce lipsa. In plus, el activeza, regleaza si stimuleaza reactiile biologice, confera enefie fizica si intelectuala, stimuleaza in mod armonios sistemul nervos, circulatia sanguina, confera organismului echilibru psihofizic si rezistenta la ofert');
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere si Catina alba - Vitaminizant -',
        30,
        1,
        'assets/images/products/miere-catina-alba-vitaminizat.jpg',
        'Este vitaminizanta, antiseptica, antiinflamatorie, anticanceroasa, intidiareica, reumatism si foarte buna pentru imunitate');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere cu miez de nuca',
        30,
        1,
        'assets/images/products/miere-miez-de-nuca.jpg',
        'Previne bolile de inima, atac vascular cerebral, colesterol si este foarte buna pentru memorie');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere cu Goji',
        30,
        1,
        'assets/images/products/miere-cu-goji.jpg',
        'Bun remediu pentru ficat, rinichi, ochi, inima, ce imbunatateste circulatia sangelui, ajuta vederea, intareste muschii si sistemul osos');
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere cu propolis, Polen si Laptisor de Matca - Energizant -',
        30,
        1,
        'assets/images/products/miere-cu-propolis-polen-laptisor-de-matca-energizant.jpg',
        'Se recomanda ca adjuvant in suprasolicitarea fizica si intelectuala, deficiente imunitare, intarzieri de crestere la copii, stari de slabiciune ale varstnicilor, reumatism, afectiuni heptice - tonic general, vitaminizant');
-- -- --
-- INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
-- values ('Miere cu scortisoara',
--         30,
--         1,
--         'assets/images/products/miere-cu-scortisoara.jpg',
--         'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue.');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere de floarea soarecului',
        30,
        1,
        'assets/images/products/miere-floarea-soarelui.jpg',
        'Recomandata in raceli, efort intelecutal, anemii, dureri de gat, febra');
-- --
-- INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
-- values ('Miere cu miez de nuca',
--         30,
--         1,
--         'assets/images/products/miere-miez-de-nuca.jpg',
--         'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue.');
-- -- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere omega 3',
        30,
        1,
        'assets/images/products/miere-omega-3.jpg',
        'Bogata in vitamine si minerale, este ideal impotriva colesterolului, constipatiei, cancerului. Contine seminte crude de in, susan, floarea-soarelui si dovleac');
-- --
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere cu propolis - Imunitate -',
        30,
        1,
        'assets/images/products/miere-propolis.jpg',
        'Ajuta la ameliorarea si chiar vindecarea unor boli, cum ar fi faringita, laringita, abscesul pulmonar, astmul bronsic, pneumonia, tusea, bolile ficatului, afectiuni ale cavitatii bucale, eliminarea parazitilor intesinatili.');
-- --
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere de rapita',
        30,
        1,
        'assets/images/products/miere-rapita.jpg',
        'Recomandata pentru bolile de ficat, rinichi si stomac, osteoporoza, artroza, pentru oase in general');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Miere de salcam',
        30,
        1,
        'assets/images/products/miere-salcam.jpg',
        'Tonic general, calmeaza tusea, folosita in tratarea nevrozelor, pentru copii, pentru intarirea sistemului imunitar si pentru gravide');
-- INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
-- values ('Miere de tei',
--         30,
--         1,
--         'assets/images/products/miere-tei.jpg',
--         'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue.');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Pastura',
        30,
        1,
        'assets/images/products/pastura.jpg',
        'Tratarea afectiunilor tubului digestiv, tratarea anemiei, hepatite, detoxifierea organismului, tratarea calcemiilor');
-- --
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Polen',
        30,
        1,
        'assets/images/products/polen.jpg',
        'Vitaminizant, regenerant, bun pentru colon, bogat in proteine, ofera energie, boli de piele, prostata, imunitate');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Propolis brut',
        30,
        1,
        'assets/images/products/propolis-brut.jpg',
        '');
-- --
INSERT INTO beelove.products (name, price, quantity, pathToImage, description)
values ('Tinctura de propolis',
        30,
        1,
        'assets/images/products/tinctura-propolis-30.jpg',
        'Efect analgezic, antihemoragic, antifungic, antiseptic, cicatrizant, febrifug, puternic regenerativ, stimuleaza imunitatea');
--