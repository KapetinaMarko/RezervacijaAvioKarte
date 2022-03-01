  function posalji(){

        let ime = document.getElementById("ime").value;
        let poruka=document.getElementById("poruka").value;
        let email=document.getElementById("email").value;


        if(ime=="" || poruka=="" || email==""){

          //document.getElementById("isp").innerHTML="Niste unijeli sve podatke, pokusajte ponovo!";
          alert("Niste unijeli sve podatke, pokušajte ponovo!");
      }else{
        alert(ime + ", Vaš komentar je zabilježen i glasio je: " + poruka + ".");
      }
      console.log(ime,poruka,email);
  }


  function promijeniPozadinu() {

    document.getElementById("naslovna").style.backgroundImage = "url('./img/naslovna-2-2.jpg')";
 
  }

   
  window.onload = function(){

    var danas = new Date();

   var datum = danas.getDate()+'/'+(danas.getMonth()+1)+'/'+  danas.getFullYear() ;
   var vrijeme = danas.getHours() + ":" + danas.getMinutes();

      var datvrij = datum + '<br> '+ vrijeme;

     document.getElementById('testSat').innerHTML=datvrij;
    }

    var pocetna = 1;
    prikaz(pocetna);
    
     function povecaj(n) {
      prikaz(pocetna += n);
    }
    
  function trenutni(n) {
      prikaz(pocetna = n);
    }
    
     function prikaz(n) {
      var i;
      var slajd = document.getElementsByClassName("mjSlide");
      var tacke = document.getElementsByClassName("tacka");
      if (n > slajd.length) {pocetna = 1}    
      if (n < 1) {pocetna = slajd.length}
      for (i = 0; i <slajd.length; i++) {
          slajd[i].style.display = "none";  
      }
      for (i = 0; i < tacke.length; i++) {
          tacke[i].className = tacke[i].className.replace(" active", "");
      }
      slajd[pocetna-1].style.display = "block";  
      tacke[pocetna-1].className += " active";
    }

    function obrisi() {
      var x = document.getElementById("brisi");
      x.remove();
    }