-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 13-Fev-2015 às 15:15
-- Versão do servidor: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `engmarcia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acesso`
--

CREATE TABLE IF NOT EXISTS `acesso` (
`acessoID` int(11) NOT NULL,
  `acessoUsuario` varchar(50) NOT NULL,
  `acessoIP` varchar(15) NOT NULL,
  `acessoData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE IF NOT EXISTS `caixa` (
`caixaID` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `funcionario` varchar(100) NOT NULL,
  `valorInicial` float(10,2) NOT NULL,
  `valorFinal` float(10,2) NOT NULL,
  `vendaInicial` int(11) NOT NULL,
  `vendaFinal` int(11) NOT NULL,
  `lancamentoInicial` int(11) NOT NULL,
  `lancamentoFinal` int(11) NOT NULL,
  `retiradaInicial` int(11) NOT NULL,
  `retiradaFinal` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dataInicio` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `caixa`
--

INSERT INTO `caixa` (`caixaID`, `usuario`, `funcionario`, `valorInicial`, `valorFinal`, `vendaInicial`, `vendaFinal`, `lancamentoInicial`, `lancamentoFinal`, `retiradaInicial`, `retiradaFinal`, `data`, `dataInicio`, `status`) VALUES
(1, 'almir', '5', 0.00, 0.00, 1, 0, 1, 0, 1, 0, '2012-11-08 13:57:15', '2012-11-08 13:57:15', 'A');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE IF NOT EXISTS `cargo` (
`cargoID` int(11) NOT NULL,
  `cargoTitulo` varchar(40) NOT NULL,
  `cargoDescricao` text NOT NULL,
  `cargoData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cargoAtivo` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`cargoID`, `cargoTitulo`, `cargoDescricao`, `cargoData`, `cargoAtivo`) VALUES
(1, 'Sócia Proprietária', '', '2013-05-20 13:46:44', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cheques`
--

CREATE TABLE IF NOT EXISTS `cheques` (
`chequeID` int(11) NOT NULL,
  `receberID` int(11) NOT NULL,
  `clienteID` int(11) NOT NULL,
  `valorCheque` float(10,2) NOT NULL,
  `numeroCheque` varchar(30) NOT NULL,
  `vencimentoCheque` date NOT NULL,
  `observacoes` text NOT NULL,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
`clienteID` int(11) NOT NULL,
  `tipoPessoa` varchar(1) NOT NULL,
  `clienteNomeFantasia` varchar(40) NOT NULL,
  `clienteRazaoSocial` varchar(40) NOT NULL,
  `clienteCnpj` varchar(20) NOT NULL,
  `clienteInscEstadual` varchar(20) NOT NULL,
  `clienteInscMunicipal` varchar(20) NOT NULL,
  `clienteEndereco` varchar(40) NOT NULL,
  `clienteNumero` varchar(6) NOT NULL,
  `clienteBairro` varchar(50) NOT NULL,
  `clienteCep` varchar(10) NOT NULL,
  `clienteCidade` varchar(20) NOT NULL,
  `clienteUf` varchar(2) NOT NULL,
  `clienteComplemento` text NOT NULL,
  `clienteContato` varchar(30) NOT NULL,
  `clienteTelefone` varchar(14) NOT NULL,
  `clienteFax` varchar(14) NOT NULL,
  `clienteRadio` varchar(15) NOT NULL,
  `clienteCelular` varchar(15) NOT NULL,
  `operadoraCelular` varchar(20) NOT NULL,
  `clienteEmail` varchar(100) NOT NULL,
  `clienteSite` varchar(100) NOT NULL,
  `clienteAtivo` varchar(1) NOT NULL DEFAULT 'S',
  `clienteData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `clienteUsuario` varchar(40) NOT NULL,
  `limiteCredito` float(16,4) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`clienteID`, `tipoPessoa`, `clienteNomeFantasia`, `clienteRazaoSocial`, `clienteCnpj`, `clienteInscEstadual`, `clienteInscMunicipal`, `clienteEndereco`, `clienteNumero`, `clienteBairro`, `clienteCep`, `clienteCidade`, `clienteUf`, `clienteComplemento`, `clienteContato`, `clienteTelefone`, `clienteFax`, `clienteRadio`, `clienteCelular`, `operadoraCelular`, `clienteEmail`, `clienteSite`, `clienteAtivo`, `clienteData`, `clienteUsuario`, `limiteCredito`) VALUES
(6, '0', 'Cláudio Lemos Pinheiro', '', '170.057.100-10', '', '365097275', 'Rua Das Orquideas', '34', 'Condomínio Quinta da Serra', '95680000', 'Canela', 'RS', '', 'Cláudio Luts', '(11) 3569-3603', '', '', '(11) 7724-4520', '', 'claudiolutz@hotmail.com', 'http://www.wix.com/claudiolutz/arquitetura', 'S', '2013-05-22 19:00:24', 'cadastro.Usuario@3feac9e8', 0.0000),
(8, '0', 'Elaine', '', '315.516.568-50', '', '337330827', 'Rua: Riachuelo', '145', 'Vila Santa Terezinha', '13220180', 'Várzea Paulista', 'SP', '', 'Elaine', '(11) 4596-0948', '', '', '', '', 'elaine@forteemmidia.com.br', 'http://', 'S', '2013-05-27 17:41:41', 'cadastro.Usuario@3a1d870a', 0.0000),
(9, '0', 'Fábio Fernando de Souza', '', '303.653.738-42', '', '33105776', 'Rua: Eugênio Carezzato', '81', 'Jardim Promeca', '13223110', 'Várzea Paulista', 'SP', '', 'Fábio ou renata', '(11) 4596-1217', '', '', '(11) 9674-55207', 'VIVO', 'fabio.fsouza@live.com', 'http://', 'S', '2013-07-26 18:20:35', 'cadastro.Usuario@5d75c67f', 0.0000),
(10, '0', 'Nilton Cesar Cardoso de Morais', '', '269.922.498-78', '', '275243151', 'Rua Gilda', '261', 'Vila Esperança', '03650000', 'São Paulo', 'SP', 'Apartamento 42', 'Flávia (esposa)', '(11) 2957-4131', '', '', '(94) 2218-72911', 'VIVO', 'flalmeida_2000@yahoo.com.br', 'http://', 'S', '2013-08-26 18:39:41', 'cadastro.Usuario@1e4ee740', 0.0000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contapagar`
--

CREATE TABLE IF NOT EXISTS `contapagar` (
`contapagarID` int(11) NOT NULL,
  `formPagID` int(11) NOT NULL,
  `favorecido` text NOT NULL,
  `valor` float(10,2) NOT NULL,
  `vezes` int(11) NOT NULL,
  `intervalo` int(11) NOT NULL,
  `data` date NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contratopadrao`
--

CREATE TABLE IF NOT EXISTS `contratopadrao` (
`contratoID` int(11) NOT NULL,
  `contratoTexto` text NOT NULL,
  `contratoData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `contratoAtivo` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `contratopadrao`
--

INSERT INTO `contratopadrao` (`contratoID`, `contratoTexto`, `contratoData`, `contratoAtivo`) VALUES
(1, '<p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DO OBJETO DO CONTRATO</span></b><span style="font-family: Verdana, sans-serif; font-size: 7.5pt;">&nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 1ª. O presente contrato tem como OBJETO, a prestação, pela CONTRATADA, dos serviços de engenharia, à CONTRATANTE, a fim de que esta possa implementar seu projeto de (......................) (Especificar o projeto que a Contratante pretende realizar a partir dos serviços acertados neste instrumento).</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DOS SERVIÇOS</span></b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 2ª. Os serviços contratados neste instrumento consistem em: (........................) (Especificar os serviços contratados).</span><span style="font-family: Verdana, sans-serif; font-size: 7.5pt;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 3ª. Além dos serviços estabelecidos na cláusula anterior, a CONTRATADA prestará também as informações técnicas necessárias à implementação do projeto, devendo também ceder à CONTRATANTE os direitos decorrentes dos processos utilizados na consecução daquele.</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DAS OBRIGAÇÕES</span></b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 4ª. Os serviços e as informações técnicas específicas utilizadas na consecução do projeto deverão ser utilizados única e exclusivamente para o fim estabelecido neste instrumento, não podendo a CONTRATANTE utilizá-los para outros projetos que por ventura esteja desenvolvendo.</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 5ª. A CONTRATANTE não poderá repassar as informações técnicas relativas aos serviços prestados para terceiros, salvo no caso de se tratar de necessidade para a implementação do projeto.<o:p></o:p></span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-family: Verdana, sans-serif; font-size: 7.5pt;">Parágrafo único. As informações técnicas que não poderão ser passadas pela CONTRATANTE serão aquelas consideradas sigilosas, ou seja, que não estejam protegidas através de concessão de patente.</span><span style="font-family: Verdana, sans-serif; font-size: 7.5pt;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 6ª. Ficará vedado à CONTRATADA, pelo prazo de (......), prestar igual serviço para o mesmo tipo de projeto a qualquer outra pessoa física ou jurídica.<o:p></o:p></span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DA MULTA</span></b><span style="font-family: Verdana, sans-serif; font-size: 7.5pt;">&nbsp; &nbsp; &nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 7ª. A parte que descumprir qualquer cláusula estabelecida neste instrumento se responsabilizará por multa de (.....)% do valor a ser pago pela prestação dos serviços.</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DO PAGAMENTO</span></b><span style="font-family: Verdana, sans-serif; font-size: 7.5pt;">&nbsp; &nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 8ª. Pela prestação dos serviços acertados, a CONTRATANTE pagará à CONTRATADA a quantia de R$ (......) (Valor expresso), dividida em (.....) parcelas de R$ (......) (Valor expresso), a serem pagas nos dias (.....).</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DA RESCISÃO</span></b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 9ª. O presente instrumento será rescindido caso uma das partes descumpra o estabelecido em qualquer uma das cláusulas deste contrato, sem isso implicar na não aplicação da multa prevista na cláusula 7ª.</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DO PRAZO</span></b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 10ª. O contrato terá prazo de (........), iniciando-se no dia (....) e terminando no dia (.....).</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">DO FORO</span></b><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp;&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Cláusula 11ª. Para dirimir quaisquer controvérsias oriundas do CONTRATO, as partes elegem o foro da comarca de (........................);</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp;</span><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">&nbsp; &nbsp; &nbsp; &nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0.0001pt;"><span style="font-size: 7.5pt; font-family: Verdana, sans-serif;">Por estarem assim justos e contratados, firmam o presente instrumento, em duas vias de igual teor, juntamente com 2 (duas) testemunhas.</span></p>', '2012-12-14 19:30:19', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `download`
--

CREATE TABLE IF NOT EXISTS `download` (
`downloadID` int(11) NOT NULL,
  `clienteID` int(11) NOT NULL,
  `arquivo` varchar(50) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `contrato` varchar(10) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
`empresaID` int(11) NOT NULL,
  `unidade` varchar(50) NOT NULL,
  `nomeFantasia` varchar(50) NOT NULL,
  `razaoSocial` varchar(80) NOT NULL,
  `ramo` varchar(30) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `inscEstadual` varchar(20) NOT NULL,
  `inscMunicipal` varchar(20) NOT NULL,
  `cep` varchar(20) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `complemento` varchar(200) NOT NULL,
  `responsavel` varchar(50) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `fax` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `operadora` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `site` varchar(100) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `empresaAtiva` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`empresaID`, `unidade`, `nomeFantasia`, `razaoSocial`, `ramo`, `cnpj`, `inscEstadual`, `inscMunicipal`, `cep`, `rua`, `numero`, `bairro`, `cidade`, `uf`, `complemento`, `responsavel`, `telefone`, `fax`, `celular`, `operadora`, `email`, `site`, `data`, `empresaAtiva`) VALUES
(1, 'Matriz', 'WBS & MPA Engenharia e Comércio LTDA', 'WBS & MPA Engenharia e Comércio LTDA', 'Engenharia Civil', '05.374.713/0001-39', '712113613110', '', '13223200', 'Rua: Victório Spinucci', '264', 'Jardim Promeca', 'Várzea Paulista', 'SP', '', 'Eng Civil Márcia de Paulo Andrade dos Santos', '(11) 4596-4716', '', '(11) 9734-78511', 'VIVO', 'wbsmpa@terra.com.br', 'www.engenheiramarcia.com.br', '2013-05-23 18:06:54', 'S'),
(2, 'filial 2', 'VARZEA INFORMATICA ', 'MASSUIA E MACEDO COM.E MANUT DE EQUIP ', 'INFORMATICA ', '11.234.557/0001-03', '712118090111 ', '', '13208052', 'Rua: dos Toneleiros', '222', 'Anhangabaú', 'Jundiaí', 'SP', '', 'claudio', '(11) 4444-4444', '', '', '', '', 'VARZEAINFORMATICA.COM.BR', '2012-11-29 12:17:47', 'N');

-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecoentrega`
--

CREATE TABLE IF NOT EXISTS `enderecoentrega` (
`idEnderecoEntrega` int(11) NOT NULL,
  `logradouro` varchar(50) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `clienteID` int(11) DEFAULT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `servicoID` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `enderecoentrega`
--

INSERT INTO `enderecoentrega` (`idEnderecoEntrega`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `uf`, `cep`, `clienteID`, `data`, `servicoID`) VALUES
(1, '', '', '', '', '', '', '', 6, '2013-05-26 22:13:50', 69),
(2, '', '', '', '', '', '', '', 6, '2013-05-27 12:37:47', 71),
(3, 'Rua: Riachuelo', '145', '', 'Vila Santa Terezinha', 'Várzea Paulista', 'SP', '13220180', 8, '2013-05-27 17:42:28', 75),
(4, 'rra', '222', 'asra', 'ff', 'fff', 'SC', '', 8, '2013-05-27 17:53:44', 76),
(5, 'Rua Victório Spinucci', '264', 'Residencial Laguna - Rua D - Q 12 - L 09', 'Jardim Promeca', 'Várzea Paulista', 'SP', '13223200', 6, '2013-05-27 18:32:22', 77),
(6, 'Avenida Itália', '', 'Quadra "2" - Lote "03"', 'Jardim Santa Lúcia', 'Várzea Paulista', 'SP', '13223210', 9, '2013-07-26 18:35:46', 80),
(7, 'Rua Victório Spinucci', '1339', 'Residencial Laguna - Rua A - Q 01 - L 05', 'Jardim promeca', 'Várzea Paulista', 'SP', '13223200', 10, '2013-08-26 20:18:48', 82);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE IF NOT EXISTS `estoque` (
`estoqueID` int(11) NOT NULL,
  `fornecedorID` int(11) NOT NULL,
  `produtoID` int(11) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `precoCusto` float(10,2) NOT NULL,
  `preco` float(10,2) NOT NULL,
  `lucro` varchar(10) NOT NULL,
  `unidade` varchar(2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(50) NOT NULL,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`estoqueID`, `fornecedorID`, `produtoID`, `quantidade`, `precoCusto`, `preco`, `lucro`, `unidade`, `data`, `usuario`, `empresaID`) VALUES
(1, 1, 2, 10.00, 25.00, 47.58, '90.32', 'UN', '2012-11-12 17:36:37', 'almir', 2),
(2, 1, 1, 40.00, 2.15, 4.75, '120.93', 'UN', '2012-11-12 17:36:42', 'almir', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `formapagamento`
--

CREATE TABLE IF NOT EXISTS `formapagamento` (
`formID` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `formAtivo` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `formapagamento`
--

INSERT INTO `formapagamento` (`formID`, `descricao`, `formAtivo`) VALUES
(1, 'Dinheiro', 'S'),
(2, 'Cartão (Crédito)', 'S'),
(3, 'Cartão (Débito)', 'S'),
(4, 'Cheque (com entrada)', 'S'),
(5, 'Cheque (sem entrada)', 'S'),
(6, 'Boleto', 'S'),
(7, 'Venda Vale', 'S'),
(8, 'DOC', 'S'),
(9, 'TED', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
`fornecedorID` int(11) NOT NULL,
  `fornNomeFantasia` varchar(40) NOT NULL,
  `fornRazaoSocial` varchar(40) NOT NULL,
  `fornCnpj` varchar(20) NOT NULL,
  `fornInscEstadual` varchar(20) NOT NULL,
  `fornInscMunicipal` varchar(20) NOT NULL,
  `fornEndereco` varchar(40) NOT NULL,
  `fornNumero` varchar(6) NOT NULL,
  `fornBairro` varchar(50) NOT NULL,
  `fornCep` varchar(12) NOT NULL,
  `fornCidade` varchar(20) NOT NULL,
  `fornUf` varchar(2) NOT NULL,
  `fornComplemento` text NOT NULL,
  `fornContato` varchar(30) NOT NULL,
  `fornTelefone` varchar(14) NOT NULL,
  `fornFax` varchar(14) NOT NULL,
  `fornRadio` varchar(15) NOT NULL,
  `fornCelular` varchar(15) NOT NULL,
  `operadoraCelular` varchar(20) NOT NULL,
  `fornEmail` varchar(100) NOT NULL,
  `fornSite` varchar(100) NOT NULL,
  `fornAtivo` varchar(1) NOT NULL DEFAULT 'S',
  `fornData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fornUsuario` varchar(40) NOT NULL,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`fornecedorID`, `fornNomeFantasia`, `fornRazaoSocial`, `fornCnpj`, `fornInscEstadual`, `fornInscMunicipal`, `fornEndereco`, `fornNumero`, `fornBairro`, `fornCep`, `fornCidade`, `fornUf`, `fornComplemento`, `fornContato`, `fornTelefone`, `fornFax`, `fornRadio`, `fornCelular`, `operadoraCelular`, `fornEmail`, `fornSite`, `fornAtivo`, `fornData`, `fornUsuario`, `empresaID`) VALUES
(1, 'Fornecedor A', 'Fornecedor A S.A. LTDA', '84.142.871/0001-30', '', '', 'Avenida: Professor Giacomo Itria', '444', 'Anhangabaú', '13208070', 'Jundiaí', 'SP', '', 'José', '(11) 4444-9999', '', '', '', '', '', 'http://', 'S', '2012-11-12 17:35:38', 'cadastro.Usuario@679810', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
`funcionarioID` int(11) NOT NULL,
  `cargoID` int(11) NOT NULL,
  `funcionarioNome` varchar(50) NOT NULL,
  `funcionarioNascimento` date NOT NULL,
  `funcionarioRg` varchar(20) NOT NULL,
  `funcionarioCpf` varchar(20) NOT NULL,
  `funcionarioEndereco` varchar(50) NOT NULL,
  `funcionarioNumero` varchar(10) NOT NULL,
  `funcionarioBairro` varchar(50) NOT NULL,
  `funcionarioCep` varchar(15) NOT NULL,
  `funcionarioCidade` varchar(40) NOT NULL,
  `funcionarioUf` varchar(2) NOT NULL,
  `funcionarioComplemento` varchar(100) NOT NULL,
  `funcionarioTelefone` varchar(15) NOT NULL,
  `funcionarioCelular` varchar(15) NOT NULL,
  `operadoraCelular` varchar(30) NOT NULL,
  `funcionarioEmail` varchar(100) NOT NULL,
  `funcionarioData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `funcionarioUsuario` varchar(40) NOT NULL,
  `funcionarioAtivo` varchar(1) NOT NULL DEFAULT 'S',
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`funcionarioID`, `cargoID`, `funcionarioNome`, `funcionarioNascimento`, `funcionarioRg`, `funcionarioCpf`, `funcionarioEndereco`, `funcionarioNumero`, `funcionarioBairro`, `funcionarioCep`, `funcionarioCidade`, `funcionarioUf`, `funcionarioComplemento`, `funcionarioTelefone`, `funcionarioCelular`, `operadoraCelular`, `funcionarioEmail`, `funcionarioData`, `funcionarioUsuario`, `funcionarioAtivo`, `empresaID`) VALUES
(6, 1, 'Márcia de Paulo Andrade dos Santos', '1967-11-07', '16775436-1', '104.038.028-06', 'Rua Victório Spinucci,264', 'Rua Vi', 'Jardim Promeca', 'Rua Vict', 'Várzea Paulista', 'SP', '', '1145964716', '(11) 9734-78511', 'VIVO', 'wbsmpa@terra.com.br', '2013-05-20 13:45:57', 'adm', 'S', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `lancamentos`
--

CREATE TABLE IF NOT EXISTS `lancamentos` (
`lancamentoID` int(11) NOT NULL,
  `receberID` int(11) DEFAULT NULL,
  `pagarID` int(11) DEFAULT NULL,
  `vendaID` int(11) DEFAULT NULL,
  `transferenciaID` int(11) DEFAULT NULL,
  `contaPagarID` int(11) DEFAULT NULL,
  `livroID` int(11) NOT NULL,
  `formID` int(11) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `desconto` float(10,2) DEFAULT NULL,
  `acrescimo` float(10,2) DEFAULT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `favorecido` text,
  `observacao` text,
  `tipo` varchar(1) NOT NULL COMMENT 'Ou ''R'' de Recebido Ou ''P'' de Pago Ou ''D'' de Deposito Ou ''T'' de Transferencia Ou ''C'' de Cheque sem Fundo Ou ''S'' de Servico',
  `usuario` varchar(50) NOT NULL,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

--
-- Extraindo dados da tabela `lancamentos`
--

INSERT INTO `lancamentos` (`lancamentoID`, `receberID`, `pagarID`, `vendaID`, `transferenciaID`, `contaPagarID`, `livroID`, `formID`, `valor`, `desconto`, `acrescimo`, `data`, `favorecido`, `observacao`, `tipo`, `usuario`, `empresaID`) VALUES
(52, 28, NULL, 71, NULL, NULL, 1, 1, 2678.20, NULL, NULL, '2013-05-27 17:07:24', NULL, NULL, 'S', 'waldiremarcia', 1),
(53, 50, NULL, 80, NULL, NULL, 1, 1, 900.00, NULL, NULL, '2013-07-26 18:39:42', NULL, '>>> ADIANTAMENTO PAGO PELO CLIENTE NA APROVAÇAO DO CONTRATO <<<', 'S', 'waldiremarcia', 1),
(54, 54, NULL, 82, NULL, NULL, 2, 9, 2000.00, 0.00, 0.00, '2013-08-27 18:54:40', NULL, 'Depósito em TED da 1&#170;. Parcela dia 23/08/2013', 'S', 'waldiremarcia', 1),
(55, 57, NULL, 84, NULL, NULL, 1, 1, 19.07, NULL, NULL, '2015-01-12 21:51:15', NULL, '>>> ADIANTAMENTO PAGO PELO CLIENTE NA APROVAÇAO DO CONTRATO <<<', 'S', 'adm', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livrocaixa`
--

CREATE TABLE IF NOT EXISTS `livrocaixa` (
`livroID` int(11) NOT NULL,
  `banco` varchar(50) NOT NULL,
  `descricao` text NOT NULL,
  `valorInicial` float(10,2) NOT NULL,
  `dataInicio` date NOT NULL,
  `ultimoLancamento` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `saldo` float(14,2) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `livrocaixa`
--

INSERT INTO `livrocaixa` (`livroID`, `banco`, `descricao`, `valorInicial`, `dataInicio`, `ultimoLancamento`, `saldo`, `status`) VALUES
(1, 'Loja', 'Caixa que recebe tudo que entra na loja', 0.00, '2012-09-24', '2015-01-12 21:51:15', 33814.59, 'S'),
(2, 'Bradesco', 'Ag&#234;ncia: 1962-3\r\nC/C: 18718-6\r\nNome: WBS & MPA Engenharia e Comércio LTDA.\r\nCNPJ: 05374713/0001-39\r\n', 2000.00, '2013-08-27', '2013-08-27 18:54:40', 4000.00, 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `orcamento`
--

CREATE TABLE IF NOT EXISTS `orcamento` (
`orcamentoID` int(11) NOT NULL,
  `clienteID` int(11) NOT NULL,
  `formPagID` int(11) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `entrada` float(10,2) NOT NULL,
  `troco` float(10,2) NOT NULL,
  `vezes` int(11) NOT NULL,
  `desconto` float(10,2) NOT NULL,
  `notaFiscal` varchar(20) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(50) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT '1',
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `orcamentoitem`
--

CREATE TABLE IF NOT EXISTS `orcamentoitem` (
`itemID` int(11) NOT NULL,
  `orcamentoID` int(11) NOT NULL,
  `produtoID` int(11) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `total` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagar`
--

CREATE TABLE IF NOT EXISTS `pagar` (
`pagarID` int(11) NOT NULL,
  `contapagarID` int(11) NOT NULL,
  `formID` int(11) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `vencimento` date NOT NULL,
  `parcela` int(11) NOT NULL,
  `de` int(11) NOT NULL,
  `status` varchar(1) NOT NULL COMMENT 'Ou ''D'' de Devendo ou ''P'' de Pago',
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parametros`
--

CREATE TABLE IF NOT EXISTS `parametros` (
`parametroID` int(11) NOT NULL,
  `codigoParametro` varchar(10) NOT NULL,
  `nomeParametro` varchar(30) NOT NULL,
  `valorParametro` int(11) NOT NULL,
  `ultimaAtualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `statusParametro` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `parametros`
--

INSERT INTO `parametros` (`parametroID`, `codigoParametro`, `nomeParametro`, `valorParametro`, `ultimaAtualizacao`, `statusParametro`) VALUES
(1, '1', 'Porcentagem Entrada', 155, '2013-03-26 23:27:52', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
`produtoID` int(11) NOT NULL,
  `tipoprodutoID` int(11) NOT NULL,
  `fornecedorID` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `unidade` varchar(2) NOT NULL,
  `precoCusto` float(10,2) NOT NULL,
  `preco` float(10,2) NOT NULL,
  `estoqueMinimo` int(11) NOT NULL,
  `estoque` float(10,2) NOT NULL,
  `lucro` varchar(10) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `produtoAtivo` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`produtoID`, `tipoprodutoID`, `fornecedorID`, `nome`, `codigo`, `unidade`, `precoCusto`, `preco`, `estoqueMinimo`, `estoque`, `lucro`, `data`, `produtoAtivo`) VALUES
(2, 2, 1, 'Carriola', '123456', 'UN', 25.00, 47.58, 2, -1.00, '90.32', '2013-05-27 17:58:43', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtoestoque`
--

CREATE TABLE IF NOT EXISTS `produtoestoque` (
`produtoestoqueID` int(11) NOT NULL,
  `produtoID` int(11) NOT NULL,
  `empresaID` int(11) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `ultimaInsercao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `produtoestoque`
--

INSERT INTO `produtoestoque` (`produtoestoqueID`, `produtoID`, `empresaID`, `quantidade`, `ultimaInsercao`) VALUES
(2, 1, 2, 38.00, '2012-12-04 17:12:40');

-- --------------------------------------------------------

--
-- Estrutura da tabela `receber`
--

CREATE TABLE IF NOT EXISTS `receber` (
`receberID` int(11) NOT NULL,
  `vendaID` int(11) NOT NULL,
  `formID` int(11) NOT NULL,
  `clienteID` int(11) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `vencimento` date NOT NULL,
  `parcela` int(11) NOT NULL,
  `de` int(11) NOT NULL,
  `status` varchar(1) NOT NULL COMMENT 'Ou ''D'' de Devendo Ou ''P'' de Pago',
  `servico` varchar(1) NOT NULL,
  `dataInclusao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=58 ;

--
-- Extraindo dados da tabela `receber`
--

INSERT INTO `receber` (`receberID`, `vendaID`, `formID`, `clienteID`, `valor`, `vencimento`, `parcela`, `de`, `status`, `servico`, `dataInclusao`, `empresaID`) VALUES
(42, 77, 9, 6, 2468.13, '2013-06-27', 1, 1, 'D', 'S', '2013-05-27 18:56:48', 1),
(43, 77, 9, 6, 2625.70, '2013-06-27', 1, 1, 'D', 'S', '2013-05-27 18:58:09', 1),
(44, 77, 9, 6, 2468.13, '2013-06-27', 1, 1, 'D', 'S', '2013-05-27 19:15:22', 1),
(45, 77, 5, 6, 875.23, '2013-06-27', 1, 3, 'D', 'S', '2013-05-27 19:15:50', 1),
(46, 77, 5, 6, 875.23, '2013-07-27', 2, 3, 'D', 'S', '2013-05-27 19:15:50', 1),
(47, 77, 5, 6, 875.23, '2013-08-27', 3, 3, 'D', 'S', '2013-05-27 19:15:50', 1),
(48, 77, 9, 6, 2599.41, '2013-06-27', 1, 1, 'D', 'S', '2013-05-27 19:22:15', 1),
(49, 77, 9, 6, 2494.42, '2013-06-27', 1, 1, 'D', 'S', '2013-05-27 19:23:45', 1),
(50, 80, 1, 9, 900.00, '2013-07-26', 1, 1, 'P', 'S', '2013-07-26 18:39:42', 1),
(51, 80, 5, 9, 881.00, '2013-08-26', 1, 3, 'D', 'S', '2013-07-26 18:44:11', 1),
(52, 80, 5, 9, 881.00, '2013-09-26', 2, 3, 'D', 'S', '2013-07-26 18:44:11', 1),
(53, 80, 5, 9, 881.00, '2013-10-26', 3, 3, 'D', 'S', '2013-07-26 18:44:11', 1),
(54, 82, 9, 10, 2000.00, '2013-08-26', 1, 1, 'P', 'S', '2013-08-26 18:47:34', 1),
(55, 82, 9, 10, 1846.13, '2013-09-26', 1, 2, 'D', 'S', '2013-08-26 18:48:55', 1),
(56, 82, 9, 10, 1846.13, '2013-10-26', 2, 2, 'D', 'S', '2013-08-26 18:48:55', 1),
(57, 84, 1, 10, 19.07, '2015-01-12', 1, 1, 'P', 'S', '2015-01-12 21:51:15', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `retiradas`
--

CREATE TABLE IF NOT EXISTS `retiradas` (
`retiradaID` int(11) NOT NULL,
  `caixaID` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `responsavel` varchar(50) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `observacao` text NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `retiradasestoque`
--

CREATE TABLE IF NOT EXISTS `retiradasestoque` (
`retiradaID` int(11) NOT NULL,
  `produtoID` int(11) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `motivo` text NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servico`
--

CREATE TABLE IF NOT EXISTS `servico` (
`servicoID` int(11) NOT NULL,
  `orcamento` int(11) NOT NULL,
  `contrato` int(11) NOT NULL,
  `clienteID` int(11) NOT NULL,
  `empresaID` int(11) NOT NULL,
  `formPagID` int(11) NOT NULL DEFAULT '0',
  `formPagIDAd` int(11) NOT NULL DEFAULT '0',
  `entrada` float(10,2) NOT NULL DEFAULT '0.00',
  `entradaAd` float(10,2) NOT NULL DEFAULT '0.00',
  `troco` float(10,2) NOT NULL DEFAULT '0.00',
  `vezes` int(11) NOT NULL DEFAULT '0',
  `vezesAd` int(11) NOT NULL DEFAULT '0',
  `desconto` float(10,2) NOT NULL DEFAULT '0.00',
  `descricao` text NOT NULL,
  `dataInicio` date NOT NULL,
  `dataContrato` date NOT NULL,
  `dataFim` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor` float(10,2) NOT NULL,
  `pagoNaAprovacao` float(10,2) NOT NULL DEFAULT '0.00',
  `numeroART` varchar(20) NOT NULL DEFAULT '',
  `usuario` varchar(50) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT 'M' COMMENT 'M (Em em andamento) OU A (Aprovado pelo Cliente) OU F (Finalizado)',
  `visualizacao` varchar(1) NOT NULL DEFAULT 'N' COMMENT 'S (sim) OU N (não)',
  `visualizar` varchar(1) NOT NULL DEFAULT 'S' COMMENT 'Permite o cliente Visualizar ou Nao no site (S/N)',
  `tipo` varchar(1) NOT NULL DEFAULT 'O' COMMENT 'O (orçamento) OU C (contrato)'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=86 ;

--
-- Extraindo dados da tabela `servico`
--

INSERT INTO `servico` (`servicoID`, `orcamento`, `contrato`, `clienteID`, `empresaID`, `formPagID`, `formPagIDAd`, `entrada`, `entradaAd`, `troco`, `vezes`, `vezesAd`, `desconto`, `descricao`, `dataInicio`, `dataContrato`, `dataFim`, `valor`, `pagoNaAprovacao`, `numeroART`, `usuario`, `status`, `visualizacao`, `visualizar`, `tipo`) VALUES
(77, 1, 1, 6, 1, 9, 9, 0.00, 2599.41, 0.00, 1, 1, 262.57, 'M&#227;o de Obra Técnica para fornecimento de projetos complementares ao arquitetônico, sendo os projetos estrutural, hidráulico e elétrico com fornecimento de ART.', '2013-05-27', '2013-05-27', '2013-05-30 16:27:40', 2494.42, 2494.42, '', '4', 'A', 'S', 'S', 'C'),
(79, 2, 0, 8, 1, 0, 0, 0.00, 0.00, 0.00, 0, 0, 0.00, 'teste', '2013-06-17', '2013-06-17', '2013-06-17 18:18:15', 0.00, 0.00, '', '5', 'M', 'N', 'S', 'O'),
(80, 3, 2, 9, 1, 5, 1, 0.00, 900.00, 0.00, 3, 1, 0.00, 'Prestaç&#227;o de Serviços Técnicos para a elaboraç&#227;o dos Projetos Arquitetônico, Executivo, de  Prefeitura e Estrutural para a Construç&#227;o de uma Resid&#234;ncia Unifamiliar com fornecimento de ART e Placa para Identificaç&#227;o da obra.', '2013-07-26', '2013-07-26', '2013-07-26 18:44:11', 2643.00, 2643.00, '', '4', 'A', 'N', 'S', 'C'),
(81, 4, 0, 8, 1, 0, 0, 0.00, 0.00, 0.00, 0, 0, 0.00, 'teste', '2013-07-26', '2013-07-26', '2013-07-26 18:34:12', 0.00, 0.00, '', '5', 'M', 'N', 'S', 'O'),
(82, 5, 3, 10, 1, 9, 9, 0.00, 2000.00, 0.00, 2, 1, 0.00, 'Prestaç&#227;o de Serviços Técnicos para Elaboraç&#227;o dos Projetos: Arquitetônico, Prefeitura e Maquete Eletrônica de sua Resid&#234;ncia Unifamiliar a ser construída na Rua "A" - Quadra 01 - Lote 05 - Residencial Laguna - Jardim Promeca - Várzea Paulista.', '2013-08-26', '2013-08-26', '2013-08-26 18:48:55', 3692.26, 3692.26, '', '4', 'A', 'N', 'S', 'C'),
(83, 1, 0, 10, 1, 0, 0, 0.00, 0.00, 0.00, 0, 0, 0.00, 'Teste', '2015-01-12', '2015-01-12', '2015-01-12 21:47:45', 0.00, 0.00, '', '4', 'M', 'N', 'S', 'O'),
(84, 2, 1, 10, 1, 0, 1, 0.00, 19.07, 0.00, 0, 1, 0.00, 'Teste', '2015-01-12', '2015-01-12', '2015-01-12 21:51:16', -6.77, 0.00, '', '4', 'A', 'N', 'S', 'C'),
(85, 3, 0, 10, 1, 0, 0, 0.00, 0.00, 0.00, 0, 0, 0.00, 'Teste', '2015-01-19', '2015-01-19', '2015-01-20 04:35:57', 16025.00, 0.00, '', '4', 'M', 'N', 'S', 'O');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicoitem`
--

CREATE TABLE IF NOT EXISTS `servicoitem` (
`servicoitemID` int(11) NOT NULL,
  `servicoID` int(11) NOT NULL,
  `descricao` text NOT NULL,
  `valor` float(10,2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicometroquadrado`
--

CREATE TABLE IF NOT EXISTS `servicometroquadrado` (
`servicometroquadradoID` int(11) NOT NULL,
  `servicoID` int(11) NOT NULL,
  `servicosID` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

--
-- Extraindo dados da tabela `servicometroquadrado`
--

INSERT INTO `servicometroquadrado` (`servicometroquadradoID`, `servicoID`, `servicosID`, `descricao`, `valor`, `quantidade`, `data`) VALUES
(1, 65, 1, 'Prefeitura', 1232.50, 85.00, '2013-04-04 10:55:54'),
(2, 66, 4, 'Estrutural', 1000.00, 100.00, '2013-04-04 23:52:52'),
(3, 67, 1, 'Prefeitura', 1305.00, 90.00, '2013-04-05 13:35:27'),
(4, 68, 4, 'Estrutural', 2387.00, 238.70, '2013-05-22 19:11:01'),
(5, 68, 5, 'Hidráulico', 1432.20, 238.70, '2013-05-22 19:31:25'),
(6, 68, 7, 'Elétrico', 1432.20, 238.70, '2013-05-22 19:31:42'),
(7, 69, 4, 'Estrutural', 2387.00, 238.70, '2013-05-23 17:46:19'),
(8, 69, 5, 'Hidráulico', 1432.20, 238.70, '2013-05-23 17:46:39'),
(9, 69, 7, 'Elétrico', 1432.20, 238.70, '2013-05-23 17:46:53'),
(11, 69, 8, 'ART', 45.00, 1.00, '2013-05-23 17:51:30'),
(12, 69, 9, 'Placa de Obra', 60.00, 1.00, '2013-05-23 17:51:54'),
(13, 70, 4, 'Estrutural', 2387.00, 238.70, '2013-05-23 18:19:08'),
(14, 70, 5, 'Hidráulico', 1432.20, 238.70, '2013-05-27 12:07:48'),
(15, 70, 7, 'Elétrico', 1432.20, 238.70, '2013-05-27 12:08:05'),
(17, 71, 4, 'Estrutural', 2387.00, 238.70, '2013-05-27 12:15:00'),
(18, 71, 5, 'Hidráulico', 1432.20, 238.70, '2013-05-27 12:15:17'),
(19, 71, 7, 'Elétrico', 1432.20, 238.70, '2013-05-27 12:15:37'),
(20, 71, 8, 'ART', 45.00, 1.00, '2013-05-27 12:16:08'),
(21, 71, 9, 'Placa de Obra', 60.00, 1.00, '2013-05-27 12:16:22'),
(22, 70, 8, 'ART', 45.00, 1.00, '2013-05-27 12:29:55'),
(23, 70, 9, 'Placa de Obra', 60.00, 1.00, '2013-05-27 12:30:14'),
(24, 72, 5, 'Hidráulico', 0.00, 0.00, '2013-05-27 12:52:56'),
(25, 72, 7, 'Elétrico', 0.00, 0.00, '2013-05-27 12:53:07'),
(26, 73, 1, 'Arquitetura / Prefeitura', 1800.00, 100.00, '2013-05-27 17:13:26'),
(27, 74, 1, 'Arquitetura / Prefeitura', 1800.00, 100.00, '2013-05-27 17:17:14'),
(28, 75, 1, 'Arquitetura / Prefeitura', 18.00, 1.00, '2013-05-27 17:43:20'),
(29, 75, 4, 'Estrutural', 10.00, 1.00, '2013-05-27 17:43:29'),
(30, 76, 5, 'Hidráulico', 6.00, 1.00, '2013-05-27 17:45:14'),
(31, 77, 4, 'Estrutural', 2387.00, 238.70, '2013-05-27 18:26:51'),
(32, 77, 5, 'Hidráulico', 1432.20, 238.70, '2013-05-27 18:27:04'),
(33, 77, 7, 'Elétrico', 1432.20, 238.70, '2013-05-27 18:27:17'),
(35, 77, 8, 'ART', 45.00, 1.00, '2013-05-27 18:30:52'),
(36, 77, 9, 'Placa de Obra', 60.00, 1.00, '2013-05-27 18:31:11'),
(37, 78, 1, 'Arquitetura / Prefeitura', 18.00, 1.00, '2013-05-27 19:12:07'),
(38, 80, 10, 'Arquitetura/Prefeitura', 2125.80, 141.72, '2013-07-26 18:38:40'),
(39, 80, 4, 'Estrutural', 1417.20, 141.72, '2013-07-26 18:39:01'),
(40, 82, 1, 'Arquitetura / Prefeitura', 4879.08, 271.06, '2013-08-26 18:44:47'),
(41, 82, 11, 'Maquete Eletrônica', 813.18, 271.06, '2013-08-26 18:46:46');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicoporcentagem`
--

CREATE TABLE IF NOT EXISTS `servicoporcentagem` (
`servicoporcentagemID` int(11) NOT NULL,
  `servicoID` int(11) NOT NULL,
  `servicosID` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `servicoporcentagem`
--

INSERT INTO `servicoporcentagem` (`servicoporcentagemID`, `servicoID`, `servicosID`, `descricao`, `valor`, `quantidade`, `data`) VALUES
(1, 65, 3, 'Mão de Obra', 5000.00, 10.00, '2013-04-04 10:56:21'),
(2, 67, 3, 'Mão de Obra', 5000.00, 10.00, '2013-04-05 13:35:55'),
(3, 72, 6, 'Material', 0.00, 20.00, '2013-05-27 12:53:17'),
(4, 75, 3, 'Mão de Obra', 0.10, 10.00, '2013-05-27 17:43:38'),
(5, 76, 6, 'Material', 0.20, 20.00, '2013-05-27 17:45:24'),
(6, 84, 3, 'Mão de Obra', 12.30, 10.00, '2015-01-12 21:51:05');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicoproduto`
--

CREATE TABLE IF NOT EXISTS `servicoproduto` (
`servicoprodutoID` int(11) NOT NULL,
  `servicoID` int(11) NOT NULL,
  `produtoID` int(11) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos`
--

CREATE TABLE IF NOT EXISTS `servicos` (
`servicoID` int(11) NOT NULL,
  `servicoTitulo` varchar(50) NOT NULL,
  `valorM` float(10,2) NOT NULL,
  `valorP` int(11) NOT NULL,
  `tipo` varchar(1) NOT NULL COMMENT '''M'' (cobrado por Metro) OU ''P'' (cobrado por Porcentagem)',
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `servicoAtivo` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Extraindo dados da tabela `servicos`
--

INSERT INTO `servicos` (`servicoID`, `servicoTitulo`, `valorM`, `valorP`, `tipo`, `data`, `servicoAtivo`) VALUES
(1, 'Arquitetura / Prefeitura', 18.00, 0, 'M', '2013-05-22 19:25:09', 'S'),
(3, 'Mão de Obra', 0.00, 10, 'P', '2012-12-03 18:24:20', 'S'),
(4, 'Estrutural', 10.00, 0, 'M', '2012-12-03 19:11:13', 'S'),
(5, 'Hidráulico', 6.00, 0, 'M', '2013-05-22 19:26:10', 'S'),
(6, 'Material', 0.00, 20, 'P', '2012-12-03 19:14:11', 'S'),
(7, 'Elétrico', 6.00, 0, 'M', '2013-05-22 19:25:51', 'S'),
(8, 'ART', 45.00, 0, 'V', '2013-05-27 18:24:02', 'S'),
(9, 'Placa de Obra', 60.00, 0, 'V', '2013-05-27 18:24:08', 'S'),
(10, 'Arquitetura/Prefeitura', 15.00, 0, 'M', '2013-07-26 18:29:14', 'S'),
(11, 'Maquete Eletrônica', 3.00, 0, 'M', '2013-08-26 18:45:41', 'S'),
(12, 'Teste Buhahahaha', 123.00, 0, 'M', '2015-01-12 21:49:24', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoproduto`
--

CREATE TABLE IF NOT EXISTS `tipoproduto` (
`tipoprodutoID` int(11) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tipoAtivo` varchar(1) NOT NULL DEFAULT 'S'
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tipoproduto`
--

INSERT INTO `tipoproduto` (`tipoprodutoID`, `tipo`, `data`, `tipoAtivo`) VALUES
(1, 'Refrigerante', '2012-11-12 17:34:24', 'S'),
(2, 'Ferramenta', '2012-11-12 17:34:35', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `transferenciaestoque`
--

CREATE TABLE IF NOT EXISTS `transferenciaestoque` (
`transferenciaID` int(11) NOT NULL,
  `usuarioID` int(11) NOT NULL,
  `empresaID` int(11) NOT NULL COMMENT 'Empresa que será retirada essa quantidade',
  `origemID` int(11) NOT NULL COMMENT 'Empresa onde será depositada a quantidade que foi retirada',
  `destinoID` int(11) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `transferencias`
--

CREATE TABLE IF NOT EXISTS `transferencias` (
`transferenciaID` int(11) NOT NULL,
  `bancoDe` int(11) NOT NULL,
  `bancoPara` int(11) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `observacoes` text NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `transferencias`
--

INSERT INTO `transferencias` (`transferenciaID`, `bancoDe`, `bancoPara`, `valor`, `observacoes`, `data`, `empresaID`) VALUES
(1, 1, 2, 3.00, 'Transferencia para cobrir taxa mensal', '2012-11-14 17:46:51', 2),
(2, 1, 2, 60.00, 'acerto', '2013-03-26 02:32:26', 1),
(3, 2, 1, 10.00, 'Reajuste', '2013-03-26 02:33:07', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`usuarioID` int(11) NOT NULL,
  `funcionarioID` int(11) NOT NULL,
  `usuarioNome` varchar(50) NOT NULL,
  `usuarioTelefone` varchar(15) NOT NULL,
  `usuarioEmail` varchar(100) NOT NULL,
  `usuarioLogin` varchar(20) NOT NULL,
  `usuarioSenha` varchar(20) NOT NULL,
  `usuarioNivel` int(11) NOT NULL,
  `usuarioData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuarioAtivo` varchar(1) NOT NULL DEFAULT 'S',
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usuarioID`, `funcionarioID`, `usuarioNome`, `usuarioTelefone`, `usuarioEmail`, `usuarioLogin`, `usuarioSenha`, `usuarioNivel`, `usuarioData`, `usuarioAtivo`, `empresaID`) VALUES
(4, 6, 'Márcia de Paulo Andrade dos Santos', '', '', 'adm', 'adm123', 1, '2013-05-20 13:48:08', 'S', 1),
(5, 6, 'Márcia de Paulo Andrade dos Santos', '', '', 'gesse', 'gesse123', 1, '2013-05-27 11:26:56', 'S', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
`vendaID` int(11) NOT NULL,
  `clienteID` int(11) NOT NULL,
  `formPagID` int(11) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `entrada` float(10,2) NOT NULL,
  `troco` float(10,2) NOT NULL,
  `vezes` int(11) NOT NULL,
  `desconto` float(10,2) NOT NULL,
  `notaFiscal` varchar(20) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(50) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT '1',
  `empresaID` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`vendaID`, `clienteID`, `formPagID`, `valor`, `entrada`, `troco`, `vezes`, `desconto`, `notaFiscal`, `data`, `usuario`, `status`, `empresaID`) VALUES
(1, 0, 3, 47.58, 10.00, 0.00, 1, 0.00, '0', '2012-11-14 12:01:23', 'almir', '2', 2),
(2, 0, 4, 47.58, 0.00, 0.00, 2, 0.00, '0', '2012-11-14 17:46:08', 'almir', '2', 2),
(3, 0, 1, 4.75, 5.00, 0.25, 1, 0.00, '0', '2012-11-14 17:46:24', 'almir', '2', 2),
(4, 2, 4, 47.58, 7.58, 0.00, 2, 0.00, '0', '2012-11-14 18:10:19', 'almir', '2', 2),
(5, 3, 5, 40.00, 0.00, 0.00, 1, 7.58, '0', '2012-12-10 14:10:24', 'almir', '2', 2),
(6, 0, 1, 47.58, 50.00, 2.42, 1, 0.00, '0', '2012-12-11 12:30:46', 'almir', '2', 2),
(7, 0, 0, 0.00, 0.00, 0.00, 0, 0.00, '0', '2012-12-11 12:30:51', 'almir', '1', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendaitem`
--

CREATE TABLE IF NOT EXISTS `vendaitem` (
`itemID` int(11) NOT NULL,
  `vendaID` int(11) NOT NULL,
  `produtoID` int(11) NOT NULL,
  `quantidade` float(10,2) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `total` float(10,2) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `vendaitem`
--

INSERT INTO `vendaitem` (`itemID`, `vendaID`, `produtoID`, `quantidade`, `valor`, `total`) VALUES
(1, 1, 2, 1.00, 47.58, 47.58),
(2, 2, 2, 1.00, 47.58, 47.58),
(3, 3, 1, 1.00, 4.75, 4.75),
(4, 4, 2, 1.00, 47.58, 47.58),
(5, 5, 2, 1.00, 47.58, 47.58),
(6, 6, 2, 1.00, 47.58, 47.58);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acesso`
--
ALTER TABLE `acesso`
 ADD PRIMARY KEY (`acessoID`);

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
 ADD PRIMARY KEY (`caixaID`);

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
 ADD PRIMARY KEY (`cargoID`);

--
-- Indexes for table `cheques`
--
ALTER TABLE `cheques`
 ADD PRIMARY KEY (`chequeID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`clienteID`);

--
-- Indexes for table `contapagar`
--
ALTER TABLE `contapagar`
 ADD PRIMARY KEY (`contapagarID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `contratopadrao`
--
ALTER TABLE `contratopadrao`
 ADD PRIMARY KEY (`contratoID`);

--
-- Indexes for table `download`
--
ALTER TABLE `download`
 ADD PRIMARY KEY (`downloadID`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
 ADD PRIMARY KEY (`empresaID`);

--
-- Indexes for table `enderecoentrega`
--
ALTER TABLE `enderecoentrega`
 ADD PRIMARY KEY (`idEnderecoEntrega`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
 ADD PRIMARY KEY (`estoqueID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `formapagamento`
--
ALTER TABLE `formapagamento`
 ADD PRIMARY KEY (`formID`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
 ADD PRIMARY KEY (`fornecedorID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
 ADD PRIMARY KEY (`funcionarioID`), ADD KEY `cargoID` (`cargoID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `lancamentos`
--
ALTER TABLE `lancamentos`
 ADD PRIMARY KEY (`lancamentoID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `livrocaixa`
--
ALTER TABLE `livrocaixa`
 ADD PRIMARY KEY (`livroID`);

--
-- Indexes for table `orcamento`
--
ALTER TABLE `orcamento`
 ADD PRIMARY KEY (`orcamentoID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `orcamentoitem`
--
ALTER TABLE `orcamentoitem`
 ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `pagar`
--
ALTER TABLE `pagar`
 ADD PRIMARY KEY (`pagarID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `parametros`
--
ALTER TABLE `parametros`
 ADD PRIMARY KEY (`parametroID`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
 ADD PRIMARY KEY (`produtoID`), ADD KEY `tipoprodutoID` (`tipoprodutoID`), ADD KEY `fornecedorID` (`fornecedorID`);

--
-- Indexes for table `produtoestoque`
--
ALTER TABLE `produtoestoque`
 ADD PRIMARY KEY (`produtoestoqueID`);

--
-- Indexes for table `receber`
--
ALTER TABLE `receber`
 ADD PRIMARY KEY (`receberID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `retiradas`
--
ALTER TABLE `retiradas`
 ADD PRIMARY KEY (`retiradaID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `retiradasestoque`
--
ALTER TABLE `retiradasestoque`
 ADD PRIMARY KEY (`retiradaID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `servico`
--
ALTER TABLE `servico`
 ADD PRIMARY KEY (`servicoID`);

--
-- Indexes for table `servicoitem`
--
ALTER TABLE `servicoitem`
 ADD PRIMARY KEY (`servicoitemID`), ADD KEY `servicoID` (`servicoID`);

--
-- Indexes for table `servicometroquadrado`
--
ALTER TABLE `servicometroquadrado`
 ADD PRIMARY KEY (`servicometroquadradoID`);

--
-- Indexes for table `servicoporcentagem`
--
ALTER TABLE `servicoporcentagem`
 ADD PRIMARY KEY (`servicoporcentagemID`);

--
-- Indexes for table `servicoproduto`
--
ALTER TABLE `servicoproduto`
 ADD PRIMARY KEY (`servicoprodutoID`), ADD KEY `servicoID` (`servicoID`);

--
-- Indexes for table `servicos`
--
ALTER TABLE `servicos`
 ADD PRIMARY KEY (`servicoID`);

--
-- Indexes for table `tipoproduto`
--
ALTER TABLE `tipoproduto`
 ADD PRIMARY KEY (`tipoprodutoID`);

--
-- Indexes for table `transferenciaestoque`
--
ALTER TABLE `transferenciaestoque`
 ADD PRIMARY KEY (`transferenciaID`);

--
-- Indexes for table `transferencias`
--
ALTER TABLE `transferencias`
 ADD PRIMARY KEY (`transferenciaID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`usuarioID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
 ADD PRIMARY KEY (`vendaID`), ADD KEY `empresaID` (`empresaID`);

--
-- Indexes for table `vendaitem`
--
ALTER TABLE `vendaitem`
 ADD PRIMARY KEY (`itemID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acesso`
--
ALTER TABLE `acesso`
MODIFY `acessoID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `caixa`
--
ALTER TABLE `caixa`
MODIFY `caixaID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
MODIFY `cargoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `cheques`
--
ALTER TABLE `cheques`
MODIFY `chequeID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
MODIFY `clienteID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `contapagar`
--
ALTER TABLE `contapagar`
MODIFY `contapagarID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contratopadrao`
--
ALTER TABLE `contratopadrao`
MODIFY `contratoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `download`
--
ALTER TABLE `download`
MODIFY `downloadID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `empresa`
MODIFY `empresaID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `enderecoentrega`
--
ALTER TABLE `enderecoentrega`
MODIFY `idEnderecoEntrega` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
MODIFY `estoqueID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `formapagamento`
--
ALTER TABLE `formapagamento`
MODIFY `formID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
MODIFY `fornecedorID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
MODIFY `funcionarioID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `lancamentos`
--
ALTER TABLE `lancamentos`
MODIFY `lancamentoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `livrocaixa`
--
ALTER TABLE `livrocaixa`
MODIFY `livroID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `orcamento`
--
ALTER TABLE `orcamento`
MODIFY `orcamentoID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `orcamentoitem`
--
ALTER TABLE `orcamentoitem`
MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pagar`
--
ALTER TABLE `pagar`
MODIFY `pagarID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `parametros`
--
ALTER TABLE `parametros`
MODIFY `parametroID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
MODIFY `produtoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `produtoestoque`
--
ALTER TABLE `produtoestoque`
MODIFY `produtoestoqueID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `receber`
--
ALTER TABLE `receber`
MODIFY `receberID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT for table `retiradas`
--
ALTER TABLE `retiradas`
MODIFY `retiradaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `retiradasestoque`
--
ALTER TABLE `retiradasestoque`
MODIFY `retiradaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `servico`
--
ALTER TABLE `servico`
MODIFY `servicoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=86;
--
-- AUTO_INCREMENT for table `servicoitem`
--
ALTER TABLE `servicoitem`
MODIFY `servicoitemID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `servicometroquadrado`
--
ALTER TABLE `servicometroquadrado`
MODIFY `servicometroquadradoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT for table `servicoporcentagem`
--
ALTER TABLE `servicoporcentagem`
MODIFY `servicoporcentagemID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `servicoproduto`
--
ALTER TABLE `servicoproduto`
MODIFY `servicoprodutoID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `servicos`
--
ALTER TABLE `servicos`
MODIFY `servicoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tipoproduto`
--
ALTER TABLE `tipoproduto`
MODIFY `tipoprodutoID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `transferenciaestoque`
--
ALTER TABLE `transferenciaestoque`
MODIFY `transferenciaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transferencias`
--
ALTER TABLE `transferencias`
MODIFY `transferenciaID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `usuarioID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
MODIFY `vendaID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `vendaitem`
--
ALTER TABLE `vendaitem`
MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cheques`
--
ALTER TABLE `cheques`
ADD CONSTRAINT `cheques_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `contapagar`
--
ALTER TABLE `contapagar`
ADD CONSTRAINT `contapagar_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
ADD CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
ADD CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`cargoID`) REFERENCES `cargo` (`cargoID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `lancamentos`
--
ALTER TABLE `lancamentos`
ADD CONSTRAINT `lancamentos_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `orcamento`
--
ALTER TABLE `orcamento`
ADD CONSTRAINT `orcamento_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `pagar`
--
ALTER TABLE `pagar`
ADD CONSTRAINT `pagar_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`tipoprodutoID`) REFERENCES `tipoproduto` (`tipoprodutoID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`fornecedorID`) REFERENCES `fornecedor` (`fornecedorID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `receber`
--
ALTER TABLE `receber`
ADD CONSTRAINT `receber_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `retiradas`
--
ALTER TABLE `retiradas`
ADD CONSTRAINT `retiradas_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `retiradasestoque`
--
ALTER TABLE `retiradasestoque`
ADD CONSTRAINT `retiradasestoque_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `servicoitem`
--
ALTER TABLE `servicoitem`
ADD CONSTRAINT `servicoitem_ibfk_1` FOREIGN KEY (`servicoID`) REFERENCES `servico` (`servicoID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `servicoproduto`
--
ALTER TABLE `servicoproduto`
ADD CONSTRAINT `servicoproduto_ibfk_1` FOREIGN KEY (`servicoID`) REFERENCES `servico` (`servicoID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `transferencias`
--
ALTER TABLE `transferencias`
ADD CONSTRAINT `transferencias_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`empresaID`) REFERENCES `empresa` (`empresaID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
