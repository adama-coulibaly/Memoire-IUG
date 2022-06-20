function ajouterPieceCompte(){

    var container = document.getElementById('Choix').style.display='none';
    var container1 = document.getElementById('Catego-Zone').style.display='none';
}
 
function supprimerPieceCompte(){
    var container = document.getElementById('Choix').style.display='block';
    var sup_attribue = document.getElementById('Choix').removeAttribute("hidden");
    var container1 = document.getElementById('Catego-Zone').style.display='block';
    var sup_attribue1 = document.getElementById('Catego-Zone').removeAttribute("hidden"); 
   
}