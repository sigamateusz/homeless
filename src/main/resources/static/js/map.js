// var geo = navigator.geolocation;
// var currentPosition = {lat: 50.26447426927488, lng: 19.023825627301026};
// var currentPosition = {};

let backgroundColor;
let zoom = 100;

const createMarker = (place, map) => {
    const marker = {
        position: place.position,
        map,
        title: place.title,
        desc: place.desc,
        img: place.img,
        longDesc: place.longDesc
    };
    return new google.maps.Marker(marker)
};

const places = {
    galeriaKatowicka: {
        position: {lat: 50.25987737797765, lng: 19.017815366687003},
        title: 'Galeria Katowicka',
        desc: 'W tym miejscu znajdują się 4 windy',
        longDesc: 'Centralnie położona duża galeria handlowa z wieloma markowymi sklepami, kinem i bogatą ofertą gastronomiczną.',
        img: 'https://lh5.googleusercontent.com/p/AF1QipPkCoSvVOOAMljvosRvYJXS1VB9UrYrwWSpB_z2=w408-h544-k-no',
        link: 'https://galeriakatowicka.eu/',
    },
    supersam: {
        position: {lat: 50.262209385638876, lng: 19.019317403735382},
        title: 'Supersam',
        desc: 'W tym miejscu znajdują się schody ruchome oraz windy',
        longDesc: 'Przestronne, nowoczesne centrum handlowe z krajowymi i międzynarodowymi sieciówkami oraz restauracjami i punktami usługowymi.',
        img: 'https://lh5.googleusercontent.com/p/AF1QipMXVCLIql2NCcSKEwMi_HKHSGVeOR0AKdzhjGz_=w408-h272-k-no',
        link: 'https://supersam-katowice.pl/',
    },
    muzeumSlaskie: {
        position: {lat: 50.26410234319751, lng: 19.03493858903854},
        title: 'Muzeum śląskie',
        desc: 'W tym miejscu znajduje się podjazd dla wózków inwalidzkich',
        longDesc: 'Dawna kopalnia węgla, w której dziś mieszczą się muzeum sztuki i przemysłu, podziemne galerie i restauracja.',
        img: 'https://lh5.googleusercontent.com/p/AF1QipPCRu3izDLfkEeOmFOYX7E4ZEzBhrAybaOE-4SD=w408-h275-k-no',
        link: 'https://muzeumslaskie.pl/pl/',
    },
    spodek: {
        position: {lat: 50.26653815995717, lng: 19.02550958136892},
        title: 'Spodek',
        desc: 'W tym miejscu znajduje się ponad 10 schodów',
        longDesc: 'Hala w kształcie latającego spodka, w której odbywają się koncerty rockowe oraz imprezy sportowe, w tym mecze koszykówki.',
        img: 'https://lh5.googleusercontent.com/p/AF1QipMaIUDlmjU7L2bmmptbyehcUWAsCct_7cXMVCa4=w408-h306-k-no',
        link: 'http://www.spodekkatowice.pl/pl/',
    },
}

const createContent = (marker) => {
    return `
                <div id="info-window" style="background-color: ${backgroundColor}">
                    <div style="text-align: center;">
                        <h1 style="font-size: ${headerSize()}">${marker.getTitle()}</h1>
                    </div>
                    <p style="text-align: center; font-size: ${paragraphSize()}">${marker.longDesc}</p>
                    <p style="text-align: center; font-size: ${paragraphSize()}">${marker.desc}</p>
                    <div style="text-align: center">
                        <img
                            src=${marker.img}
                            alt=${marker.getTitle()}
                            class="map-info-img"
                            style="min-width:${zoom === 100 ? '400px' : '600px'}; max-height: 500px"
                        >
                    </div>
                </div>
            `;
};

function initMap() {
    const geo = navigator.geolocation;
    let currentPosition;
    if (geo) {
        geo.getCurrentPosition(function (location) {
            currentPosition = {lat: location.coords.latitude, lng: location.coords.longitude};

            const map = new google.maps.Map(document.getElementById("map"), {zoom: 15, center: currentPosition});
            const infoWindow = new google.maps.InfoWindow();

            Object.getOwnPropertyNames(places)
                .map(key => createMarker(places[key], map))
                .forEach(marker => {
                    marker.addListener("click", () => {
                        speech(marker.getTitle());
                        speech(marker.longDesc);
                        speech(marker.desc);
                        infoWindow.close();
                        infoWindow.setContent(createContent(marker));
                        infoWindow.open(marker.getMap(), marker);
                        debugger;
                    });
                });


        });
    } else {
        console.log('brak dostępu do lokalizacji');
    }
}
