# mini-server-html-static
Permet de générer des pages html statiques. Utile pour les petits sites non dynamique.

src/java/generate.html/<br>
  |- balise: regroupe les balises du web html5<br>
  |- generator : permet de lancer la génération du page static<br>
  |- page : AbstractPageHtml.java permet de définir unne page html par un header et footer présent dans les ressources resources/xml/footer.xml et resources/xml/header.xml. Les autres classe sont sépcifiques au site.<br>
  |- xml : Définit les structures des articles en xml à retranscrire sur le site, spécifique au site.<br>
<br>
<br>
src/java/resources/<br>
  |- html : base des pages html<br>
  |- xml : fichier header et footer décivant l'entête et le pied de chaque page, les autres sont des fichiers dédié aux articles du site.<br>
