-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 03 Novembre 2016 à 13:59
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `beerfinder`
--

--
-- Vider la table avant d'insérer `bar`
--

TRUNCATE TABLE `bar`;
--
-- Contenu de la table `bar`
--

INSERT INTO `bar` (`id`, `name`, `reference`) VALUES
(1, 'La Divina', 'ChIJ3eFVJHTr9EcRVY7ScLQyfuA'),
(2, 'Nakamal', 'ChIJSylK_Hbr9EcRiMEZFW2YSCo'),
(3, 'O Jardin', 'ChIJw6uh13Pr9EcR4LVXM2noWH8'),
(4, 'Caffe e Cuccine', 'ChIJ_aKGx3Pr9EcRw71QPa5Dkuk'),
(5, 'Au Gré des Jours', 'ChIJfxf4iXLr9EcRdNhfex_44tQ'),
(6, 'L\'assiette Du Marché', 'ChIJszxvgHLr9EcRJfZoquashEU'),
(7, 'Le Bistrot de Vaise', 'ChIJj-DNdXLr9EcRDRBrRB9a3cY'),
(8, 'Le Cap', 'ChIJ1Xi_qnbr9EcR39uci9vbzfY'),
(9, 'Comptoir du 9e - Chez Olivia', 'ChIJ1YFjAHTr9EcRBg_WtfCoIrA'),
(10, 'Le Mecy', 'ChIJxdjRZXHr9EcRszsZxDxumak'),
(11, 'Mydo', 'ChIJw6uh13Pr9EcRop4twDuQPuk'),
(12, 'Le Desportivo', 'ChIJecoXJnHr9EcRsEbZvKBxrD0'),
(13, 'Grand café de la Place', 'ChIJbaHkMHLr9EcRnnQbxeXWByU'),
(14, 'Café De La Paix', 'ChIJt8tmWHLr9EcRCyp03EL2i08'),
(15, 'Le Petit Loup', 'ChIJt4jq13br9EcRFnpMWzCKa9Q'),
(16, 'Grand Café du Commerce', 'ChIJkQ4_lHLr9EcRIl1bZsGIMCI'),
(17, 'Mini-Bar', 'ChIJB8EKvXLr9EcRQ783bNnDJJk'),
(18, 'Presto Pizza', 'ChIJ0wmXtnLr9EcRpOzBMlAeENM'),
(19, 'L\'huillier Andrée', 'ChIJz2petXLr9EcR4uei2WrRtOU'),
(20, 'Class Kebab Pamukkale', 'ChIJkSwTNQ3r9EcRiqUh4emvKak'),
(21, 'Le Liberté Bar', 'ChIJT3QPz03A9EcR8hJl50vWG6Y'),
(22, 'Café Du Terminus', 'ChIJjYZHpk7A9EcRX9nKZiPYItQ'),
(23, 'La Gaité', 'ChIJ48_j5kvA9EcRDB9hRY7Z-cw'),
(24, 'La Gaieté', 'ChIJ1QNv5EvA9EcRS6gZJBakmfo'),
(25, 'Restaurant Annecy - Les Chineurs de la Cuisine', 'ChIJeffZO_mPi0cRmLHVhoio1Yk'),
(26, 'L\'Estaminet', 'ChIJhwiPYPmPi0cR8gQhzEEfY4g'),
(27, 'Captain Pub', 'ChIJyb4k3vuPi0cR3EaS4ptMtTI'),
(28, 'Brasserie Saint Maurice', 'ChIJUWoyNfqPi0cR084gW03qPis'),
(29, 'Café Saint-Antoine', 'ChIJRzXTLvqPi0cR6OGo_TFXB84'),
(30, 'Restaurant L\'Etage', 'ChIJQ_vzGfqPi0cRkgv-jjwuis8'),
(31, 'L\'Alpin', 'ChIJ42oPYPmPi0cRUoTpB3RpSPk'),
(32, 'L\'Appart du 17', 'ChIJ13igGfqPi0cRUS_dtPGNwYE'),
(33, 'Finn Kelly\'s Irish Pub', 'ChIJ88YWcPuPi0cRKIN4tExyaEY'),
(34, 'Le Kebab - Chez APO', 'ChIJudhxYPmPi0cRyJMJwNL2rDI'),
(35, 'Brasserie du Paquier', 'ChIJ13igGfqPi0cRqe9OCyQZu10'),
(36, 'Le Rital', 'ChIJNWef0vuPi0cRnqik3xSDtvE'),
(37, 'LE GRAND CAFE', 'ChIJLSvk3_uPi0cR9Om-93rOWqM'),
(38, 'Le Petit Bouchon', 'ChIJuW-zQfmPi0cReRbtMjD-qjk'),
(39, 'Le Sapaudia', 'ChIJy58FMvmPi0cRFCA8QWnm85s'),
(40, 'Salle des Gardes', 'ChIJI3c4vPuPi0cR3pINpbkiBhs'),
(41, 'Le munich', 'ChIJs9bGCvuPi0cRdvjorlj3Cbk'),
(42, 'Le Cochon à l\'Oreille', 'ChIJpRAsdfuPi0cR32uHx8aHFIQ'),
(43, 'La Bastille', 'ChIJz7pFvPuPi0cRUmdEG_fj1kU'),
(44, 'Le Saint Clair', 'ChIJFTRzQvmPi0cReWV0_23GUBU');

--
-- Vider la table avant d'insérer `bar_beers`
--

TRUNCATE TABLE `bar_beers`;
--
-- Contenu de la table `bar_beers`
--

INSERT INTO `bar_beers` (`bars_id`, `beers_id`) VALUES
(3, 1),
(3, 2),
(3, 4),
(3, 10),
(4, 2),
(4, 8),
(24, 2),
(24, 5),
(24, 6),
(24, 8),
(24, 9),
(24, 10),
(24, 11),
(27, 1),
(27, 2),
(27, 3),
(27, 4),
(27, 5),
(27, 6),
(27, 9),
(28, 1),
(28, 2),
(28, 3),
(28, 5),
(28, 6),
(28, 7),
(28, 10),
(28, 11),
(29, 2),
(29, 3),
(29, 4),
(29, 6),
(29, 7),
(29, 8),
(29, 9),
(29, 10),
(29, 11),
(30, 1),
(30, 2),
(30, 3),
(30, 4),
(30, 9),
(31, 1),
(31, 2),
(31, 3),
(31, 4),
(31, 6),
(31, 7),
(31, 8),
(31, 9),
(31, 11);

--
-- Vider la table avant d'insérer `beer`
--

TRUNCATE TABLE `beer`;
--
-- Contenu de la table `beer`
--

INSERT INTO `beer` (`id`, `country`, `name`, `type`) VALUES
(1, 'Chine', 'Tsingtao', 'Blanche'),
(2, 'Pays-Bas', 'Heineken', 'Blonde'),
(3, 'Pologne', 'Carlsberg', 'Blonde'),
(4, 'Belgique', 'Chouffe', 'Blonde'),
(5, 'Belgique', 'Leffe Rubis', 'Fruitée'),
(6, 'Belgique', 'Leffe des Vignes', 'Blonde'),
(7, 'Belgique', 'Cuvée des Trolls', 'Blonde'),
(8, 'Belgique', 'Kriek Foudroyante', 'Lambic - Fruitée'),
(9, 'Allemagne', 'Paulaner Salvator', 'Ambrée'),
(10, 'Allemagne', 'Erdinger Pikantus', 'Brune'),
(11, 'Pays-Bas', 'Trappe Quadrupel', 'Ambrée');

--
-- Vider la table avant d'insérer `report`
--

TRUNCATE TABLE `report`;
--
-- Contenu de la table `report`
--

INSERT INTO `report` (`id`, `bar_id`, `beer_id`) VALUES
(1, 31, 7),
(2, 31, 2),
(3, 27, 1),
(4, 27, 1),
(5, 27, 1),
(6, 27, 3),
(7, 27, 1),
(8, 29, 6),
(9, 29, 6),
(10, 29, 9),
(11, 31, 2),
(12, 31, 8),
(13, 27, 3),
(14, 27, 9),
(15, 27, 3),
(16, 27, 1),
(17, 27, 9),
(18, 29, 3),
(19, 29, 10),
(20, 29, 2),
(21, 28, 7),
(22, 28, 3),
(23, 28, 6),
(24, 28, 7),
(25, 28, 3),
(26, 28, 1),
(27, 28, 5),
(28, 28, 5),
(29, 28, 5),
(30, 28, 3),
(31, 28, 3),
(32, 28, 1),
(33, 28, 1),
(34, 28, 7),
(35, 28, 6),
(36, 28, 6),
(37, 28, 7),
(38, 28, 7),
(39, 28, 11),
(40, 29, 3);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
