
/*Quito la función de redireccionar el elemento a en el botón "Iniciar Sesion"*/
 const a = document.getElementById("aIniciarSesion");
 a.removeEventListener("click",  { passive: true });

/*Quito la función de redireccionar el elemento a en el botón "Olvidar contraseña"*/
const a1 = document.getElementById("olvidarContraseña");
a1.addEventListener("click", () =>{
    Swal.fire({
        icon: 'warning',
        title: 'Oops...',
        text: 'El sitio web se encuentra en mantenimiento.',
        footer: 'Pruebe en unos días'
    })
});

const facebook = document.getElementById("aAcceder");
facebook.addEventListener("click", () =>{
    Swal.fire(
        'Oops...',
        'No se puede iniciar sesión con Facebook',
        'warning'
    )
});


const btnAcceder = document.getElementById("btnAcceder");
btnAcceder.addEventListener("click", async() =>{
    let timerInterval
    Swal.fire({
        title: 'Cargando sesión...',
        html: 'Esto puede tardar unos segundos....',
        timer: 2000,
        timerProgressBar: true,
        didOpen: () => {
            Swal.showLoading()
            timerInterval = setInterval(() => {
                const content = Swal.getContent()
                if (content) {
                    const b = content.querySelector('b')
                    if (b) {
                        b.textContent = Swal.getTimerLeft()
                    }
                }
            }, 100)
        },
        willClose: () => {
            clearInterval(timerInterval)
        }
    }).then((result) => {
        /* Read more about handling dismissals below */
        if (result.dismiss === Swal.DismissReason.timer) {
            console.log('cerrando temporizador')
        }
    })
    await esperar(2100);
    location.href= "miCuenta.html";
})


function esperar(milisegundos){
    /*Creo una promesa que será la que espere el await*/
    return new Promise(resolve => setTimeout(resolve, milisegundos))
}