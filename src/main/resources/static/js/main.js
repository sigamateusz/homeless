const createMarker = (place, map) => {
    const marker = {
        position: {lat: Number(place.lat), lng: Number(place.lng)},
        map,
        title: place.name,
        desc: place.desc,
        donorType: place.type
    };
    return new google.maps.Marker(marker)
};

const createContent = (marker) => {
    return `
                <div id="info-window">
                    <div style="text-align: center;">
                        <h1>${marker.donorType}</h1>
                        <h2>${marker.getTitle()}</h2>
                    </div>
                    <p style="text-align: center; font-size: 16px">${marker.desc}</p>
                </div>
            `;
};

const getJSON = function (url, callback) {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        const status = xhr.status;
        if (status === 200) {
            callback(null, xhr.response);
        } else {
            callback(status, xhr.response);
        }
    };
    xhr.send();
};

function initMapNeedyPerson() {
    let places2;
    getJSON('http://localhost:8080/all',
        function (err, data) {
            if (err !== null) {
                alert('Something went wrong: ' + err);
            } else {
                places2 = data;
                const geo = navigator.geolocation;
                let currentPosition;
                if (geo) {
                    geo.getCurrentPosition(function (location) {
                        currentPosition = {lat: location.coords.latitude, lng: location.coords.longitude};

                        const map = new google.maps.Map(document.getElementById("map"), {
                            zoom: 15,
                            center: currentPosition
                        });
                        let infoWindow = new google.maps.InfoWindow();
                        places2.map(place => createMarker(place, map))
                            .forEach(marker => {
                                marker.addListener("click", () => {
                                    infoWindow.close();
                                    infoWindow.setContent(createContent(marker));
                                    infoWindow.open(marker.getMap(), marker);
                                });
                            });
                    });
                } else {
                    console.log('brak dostępu do lokalizacji');
                }
            }
        });
}

function initMapDonor() {
    const geo = navigator.geolocation;
    let currentPosition;
    if (geo) {
        geo.getCurrentPosition(function (location) {
            currentPosition = {lat: location.coords.latitude, lng: location.coords.longitude};

            const map = new google.maps.Map(document.getElementById("map"), {zoom: 15, center: currentPosition});
            let infoWindow = new google.maps.InfoWindow();
            map.addListener("click", (mapsMouseEvent) => {
                infoWindow.close();
                let latLng = mapsMouseEvent.latLng.toJSON();

                document.getElementById('lat').value = latLng.lat;
                document.getElementById('lng').value = latLng.lng;
            });
        });
    } else {
        console.log('brak dostępu do lokalizacji');
    }
}
