   // determinarndo el ID dia
    const diaSelect = document.getElementById('dia');

    // Funcion para generar dias en el formulario
    function generateOptions() {
        for (let i = 1; i <= 30; i++) {
            const option = document.createElement('option');
            option.value = i;
            option.textContent = i;
            diaSelect.appendChild(option);
        }
    }

    // Generaar al cargar pagina
    generateOptions();
    
    
    
        
        // // determinarndo el ID meses
    const monthSelect = document.getElementById('meses');

    //// Funcion para generar opciones meses
    function generateMonthOptions() {
        const monthNames = [
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        ];

        for (let i = 0; i < monthNames.length; i++) {
            const option = document.createElement('option');
            option.value = i; // Use index as value for simplicity
            option.textContent = monthNames[i];
            monthSelect.appendChild(option);
        }
    }

    // Generate meses opciones
    generateMonthOptions();
    
    
    
    
    
    
    
    
        // determinarndo el ID año
    const yearSelect = document.getElementById('anio');

    // Funcion para generar años
    function generateYearOptions(startYear, endYear) {
        for (let year = startYear; year <= endYear; year++) {
            const option = document.createElement('option');
            option.value = year;
            option.textContent = year;
            yearSelect.appendChild(option);
        }
    }

    // inicio y termino funcion años
    const currentYear = new Date().getFullYear();
    const startYear = currentYear - 90; // inicia 90 años en el pasado
    const endYear = currentYear - 18   // determinarndo el ID; // End 10 years in the future

    // Crea opcopiones
    generateYearOptions(startYear, endYear);
    
