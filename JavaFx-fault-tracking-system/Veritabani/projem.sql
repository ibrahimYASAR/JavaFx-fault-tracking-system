-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 03 Haz 2022, 19:00:43
-- Sunucu sürümü: 8.0.29
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `projem`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `islemler`
--

CREATE TABLE `islemler` (
  `Iid` int NOT NULL,
  `user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `islemAciklama` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `islemTutar` double NOT NULL,
  `islemTarih` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

CREATE TABLE `kullanici` (
  `k_id` int NOT NULL,
  `k_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `k_pass` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`k_id`, `k_user`, `k_pass`) VALUES
(1, 'hamza', '202cb962ac59075b964b07152d234b70'),
(2, 'ismail', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `Kid` int NOT NULL,
  `kul_ad` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`Kid`, `kul_ad`, `sifre`) VALUES
(1, 'admin', '7363a0d0604902af7b70b271a0b96480'),
(2, 'ibrahim', '81dc9bdb52d04dc20036dbd8313ed055'),
(12, 'hamza', 'd9b1d7db4cd6e70935368a1efb10e377');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `musteri`
--

CREATE TABLE `musteri` (
  `M_id` int NOT NULL,
  `M_ad` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `M_soy` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `M_mail` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `M_tel` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `M_sikayet` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `M_aciklama` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `M_alet` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `M_masraf` int DEFAULT NULL,
  `M_Urun_bilgi` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `M_tc` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `M_talep` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `M_kod` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `para` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `PersonelAciklama` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `yapilanislem` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL,
  `teslimatdurum` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `musteri`
--

INSERT INTO `musteri` (`M_id`, `M_ad`, `M_soy`, `M_mail`, `M_tel`, `M_sikayet`, `M_aciklama`, `M_alet`, `M_masraf`, `M_Urun_bilgi`, `M_tc`, `M_talep`, `M_kod`, `para`, `PersonelAciklama`, `yapilanislem`, `teslimatdurum`) VALUES
(6, 'ismail', 'özdoğan', 'ismos51@hotmail.com', '05374584420', 'yok, herşey iyi', 'temiz yapmıyor, ses çıkarıyor', 'süpürge', 2555, 'onarılıyor', '15164864848', 'böyle devam', '02', 'borc', 'filtre ölmüş, motor ömrü az', 'null', 'null'),
(7, 'süleyman', 'atahan', 'süleyman@hotmail.com', '54478932145', 'şikayetim yok', 'ısıtmıyor', 'soba', 780, 'onarıldı', '12315648978', 'böyle devam', '04', 'peşin', 'soba teli kopmuş', 'tel değişti', 'teslim edildi'),
(8, 'onur', 'bingöl', 'onur12@gmail.com', '564896559', 'yok', 'batarya erken bitiyor', 'telefon', 1450, 'onarıldı', '16518949', 'yok', '05', 'borç', 'batarya ölmüş', 'batarya değişimi', 'teslim edildi'),
(9, 'şükrü', 'elma', 'şükrüElma@gmail.com', '654894561', NULL, 'kaynatmıyor', 'ketıl', 1250, 'onarıldı', '984861651', NULL, '06', 'peşin', 'ısıtıcı termos bozulmuş', 'termos değişti', 'teslim edildi'),
(10, 'baran', 'şen', 'baran@gmail.com', '848948949', 'düzelmedi', 'su atmıyor', 'duş başlığı', 650, 'onarılıyor', '4894894894', 'personnleri kov', '07', 'peşin', 'duş dişi kırılmış', 'diş değişti', 'teslim edildi'),
(11, 'meltem', 'avcı', 'meltemavci@gmail.com', '7777777', 'şikayetim yok', 'tıklamıyor', 'mause', 750, 'anarıldı', '49849849', 'personel iyi', '07', 'peşin', 'tıklama aparatı bozulmuş', 'aparat değişti', 'teslim edildi'),
(12, 'ahmet', 'yalçınn', 'Ahmetyalcın@gmail.com', '0414236578', 'şikayetim yok', 'soğutmuyor', 'klima', 4500, 'onarıldı', '14257896227', 'gayet iyi böyle devam', '17', 'pesin', 'gazı bitmiş', 'gaz eklendi', 'teslim edilidi'),
(13, 'mustafa', 'avşar', 'mustafa@gmail.com', '231549813', 'telefon yine bozuldu', 'telefon düştü,ses gelmiyor', 'telefon', 1520, 'onarılıyor', '5689481231', 'personeli uyarın', '', 'pesin', 'hoperlor bozulmuş', 'hoperlor değiştirildi', 'teslim edildi'),
(14, 'derya', 'ayser', 'deryaa@gmail.com', '489484812', 'hor kullanılmış', 'ses gelmiyor', 'telefon', 14252, 'anarıldı', '489489412', 'personlei uyarın', 'belirlenmedi', 'pesin', 'hoperlor bozulmuş', 'hoperlor değiştirildi', 'teslim edildi'),
(15, 'harun', 'akdağsoy', 'harun36663@gmail.com', '87895465167', 'telefon yine bozuldu', 'düştü', 'telefon', 4953, 'onarıldı', '89465818517', 'personeli uyarın', 'bilinmiyor', 'peşin', 'ekranı kırıldı', 'ekran değişti', 'teslim edildi'),
(16, 'meltemm', 'altunn', 'meltem@gmail.com', '498889487', 'tuşlar bozuldu yeniden', 'tuşa basmıyor', 'klavye', 1200, 'onarıldı', '89498189518', 'yok', 'bilinmiyor', 'peşin', 'bütün tuşlar bozuk', 'tuşlar değişti', 'teslim edildi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE `personel` (
  `per_id` int NOT NULL,
  `per_adSoy` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `per_alan` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `per_adres` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `per_maas` double NOT NULL,
  `per_tarih` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`per_id`, `per_adSoy`, `per_alan`, `per_adres`, `per_maas`, `per_tarih`) VALUES
(6, 'özgür hami', 'metalürji', 'sinop', 8975, '2022-05-25 21:25:41'),
(7, 'ali aslan', 'elektronik', 'antep', 1250, '2022-05-29 14:07:13'),
(8, 'mehmet', 'klima teknisyeni', 'yozgat', 6585, '2022-06-01 17:03:52'),
(9, 'mert', 'elektrikçi', 'istanbul', 1450, '2022-06-03 17:28:35'),
(10, 'ayşe', 'temizlik', 'muğla', 4450, '2022-06-03 17:52:45'),
(11, 'elif', 'beyaz eşya', 'balıkesir', 4070, '2022-06-03 18:10:51'),
(12, 'halil', 'beyaz eşya', 'muğla', 9999, '2022-06-03 18:36:29');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `teslimatlar`
--

CREATE TABLE `teslimatlar` (
  `id` int NOT NULL,
  `personelAd` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `musteriAd` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `alet` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL,
  `yapilanislem` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `teslimatlar`
--

INSERT INTO `teslimatlar` (`id`, `personelAd`, `musteriAd`, `alet`, `yapilanislem`) VALUES
(1, 'sad', 'asda', 'asda', 'asdas'),
(2, 'asda', 'asd', 'adas', 'asdasd'),
(3, 'yusuf yapar', 'süleyman', 'soba', 'tel değişti'),
(4, 'yusuf yapar', 'onur', 'telefon', 'batarya değişimi'),
(5, 'eyüp serenkili', 'şükrü', 'ketıl', 'termos değişti'),
(6, 'özgür hami', 'baran', 'duş başlığı', 'diş değişti'),
(7, 'ali aslan', 'meltem', 'mause', 'aparat değişti'),
(8, 'mehmet', 'ahmet', 'klima', 'gaz eklendi'),
(9, 'ali aslan', 'mustafa', 'telefon', 'hoperlor değiştirildi'),
(10, 'ali aslan', 'derya', 'telefon', 'hoperlor değiştirildi'),
(11, 'mert', 'harun', 'telefon', 'ekran değişti'),
(12, 'ali aslan', 'meltemm', 'klavye', 'tuşlar değişti');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `islemler`
--
ALTER TABLE `islemler`
  ADD PRIMARY KEY (`Iid`);

--
-- Tablo için indeksler `kullanici`
--
ALTER TABLE `kullanici`
  ADD PRIMARY KEY (`k_id`);

--
-- Tablo için indeksler `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Kid`);

--
-- Tablo için indeksler `musteri`
--
ALTER TABLE `musteri`
  ADD PRIMARY KEY (`M_id`);

--
-- Tablo için indeksler `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`per_id`) USING BTREE;

--
-- Tablo için indeksler `teslimatlar`
--
ALTER TABLE `teslimatlar`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `islemler`
--
ALTER TABLE `islemler`
  MODIFY `Iid` int NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `kullanici`
--
ALTER TABLE `kullanici`
  MODIFY `k_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `login`
--
ALTER TABLE `login`
  MODIFY `Kid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Tablo için AUTO_INCREMENT değeri `musteri`
--
ALTER TABLE `musteri`
  MODIFY `M_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Tablo için AUTO_INCREMENT değeri `personel`
--
ALTER TABLE `personel`
  MODIFY `per_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Tablo için AUTO_INCREMENT değeri `teslimatlar`
--
ALTER TABLE `teslimatlar`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
