async function handleColorCategoryClick() {
    try {
        const response = await fetch('/categories/colors');
        if (!response.ok) {
            throw new Error('Renkler yüklenirken hata oluştu');
        }
        const data = await response.json();
        // Renkleri görüntüleme kodları
    } catch (error) {
        console.error('Hata:', error);
    }
} 