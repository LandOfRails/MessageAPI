package net.landofrails.MessageAPI.api;

import java.util.Optional;

/**
 * 
 * Contains almost every minecraft language.
 * 
 * @author Daniel
 *
 */
public enum ELanguage {

	// @formatter:off
	AFRIKAANS("Afrikaans", "af_za"),
	ARABIC("اللغة العربية (alLoğeẗ al'Arabiyeẗ)", "ar_sa"),
	ASTURIAN("Asturianu", "ast_es"),
	AZERBAIJANI("Azərbaycanca", "az_az"),
	BASHKIR("Башҡортса", "ba_ru"),
	BAVARIAN("Boarisch", "bar"),
	BELARUSIAN("Беларуская (Belaruskaâ)", "be_by"),
	BULGARIAN("Български (Bălgarski)", "bg_bg"),
	BRETON("Brezhoneg", "br_fr"),
	BRABANTIAN("Brabants", "brb"),
	BOSNIAN("Bosanski", "bs_ba"),
	CATALAN("Català", "ca_es"),
	CZECH("Čeština", "cs_cz"),
	WELSH("Cymraeg", "cy_gb"),
	DANISH("Dansk", "da_dk"),
	GERMAN("Deutsch", "de_de"),
	AUSTRIAN_GERMAN("Österreichisches Deitsch", "de_at"),
	SWISS_GERMAN("Schwiizerdutsch", "de_ch"),
	GREEK("Ελληνικά (Ellêniká)", "el_gr"),
	AMERICAN_ENGLISH("English (US)", "en_us"),
	AUSTRALIAN_ENGLISH("English (Australia)", "en_au"),
	CANADIAN_ENGLISH("English (Canada)", "en_ca"),
	BRITISH_ENGLISH("English (United Kingdom)", "en_gb"),
	NEW_ZEALAND_ENGLISH("English (New Zealand)", "en_nz"),
	PIRATE_ENGLISH("Pirate Speak", "en_pt"),
	BRITISH_ENGLISH_UPSIDE_DOWN("ɥsᴉꞁᵷuƎ (ɯopᵷuᴉꞰ pǝʇᴉuՈ)", "en_ud"),
	ENGLISH_PURISTIC("Anglish", "enp"),
	EARLY_MODERN_ENGLISH("Shakespearean English", "enws"),
	ESPERANTO("Esperanto", "eo_uy"),
	SPANISH("Español (España)", "es_es"),
	ARGENTINIAN_SPANISH("Español (Argentina)", "es_ar"),
	CHILEAN_SPANISH("Español (Chile)", "es_cl"),
	ECUADORIAN_SPANISH("Español (Ecuador)", "es_ec"),
	MEXICAN_SPANISH("Español (México)", "es_mx"),
	URUGUAYAN_SPANISH("Español (Uruguay)", "es_uy"),
	VENEZUELAN_SPANISH("Español (Venezuela)", "es_ve"),
	ANDALUSIAN("Andalûh", "esan"),
	ESTONIAN("Eesti", "et_ee"),
	BASQUE("Euskara", "eu_es"),
	PERSIAN("فارسی (Fārsiy)", "fa_ir"),
	FINNISH("Suomi", "fi_fi"),
	FILIPINO("Filipino", "fil_ph"),
	FAROESE("Føroyskt", "fo_fo"),
	FRENCH("Français", "fr_fr"),
	CANADIAN_FRENCH("Français québécois", "fr_ca"),
	EAST_FRANCONIAN("Frängisch", "fra_de"),
	FRISIAN("Frysk", "fy_nl"),
	IRISH("Gaeilge", "ga_ie"),
	SCOTTISH_GAELIC("Gàidhlig", "gd_gb"),
	GALICIAN("Galego", "gl_es"),
	GOTHIC‌("Gutrazda", "got_de"),
	MANX("Gaelg", "gv_im"),
	HAWAIIAN("ʻŌlelo Hawaiʻi", "haw_us"),
	HEBREW("עברית ('Ivriyþ)", "he_il"),
	HINDI("हिन्दी (Hindī)", "hi_in"),
	CROATIAN("Hrvatski", "hr_hr"),
	HUNGARIAN("Magyar", "hu_hu"),
	ARMENIAN("Հայերեն (Hayeren)", "hy_am"),
	INDONESIAN("Bahasa Indonesia", "id_id"),
	IGBO("Igbo", "ig_ng"),
	IDO("Ido", "io_en"),
	ICELANDIC("Íslenska", "is_is"),
	INTERSLAVIC("Medžuslovjansky", "isv"),
	ITALIAN("Italiano", "it_it"),
	JAPANESE("日本語 (Nihongo/Nippongo)", "ja_jp"),
	LOJBAN("la .lojban.", "jbo_en"),
	GEORGIAN("ქართული (Kharthuli)", "ka_ge"),
	KABYLE‌("Taqbaylit", "kab_kab"),
	KAZAKH("Қазақша (Qazaqşa)", "kk_kz"),
	KANNADA("ಕನ್ನಡ (Kannađa)", "kn_in"),
	KOREAN("한국어 (Hangug'ô)", "ko_kr"),
	KÖLSCH_RIPUARIAN("Kölsch/Ripoarisch", "ksh"),
	CORNISH("Kernewek", "kw_gb"),
	LATIN("Latina", "la_la"),
	LUXEMBOURGISH("Lëtzebuergesch", "lb_lu"),
	LIMBURGISH("Limburgs", "li_li"),
	LOLCAT("LOLCAT", "lol_us"),
	LITHUANIAN("Lietuvių", "lt_lt"),
	LATVIAN("Latviešu", "lv_lv"),
	MĀORI‌("Te Reo Māori", "mi_nz"),
	MACEDONIAN("Македонски (Makedonski)", "mk_mk"),
	MONGOLIAN("Монгол (Mongol)", "mn_mn"),
	MOHAWK‌("Kanien’kéha", "moh_ca"),
	MALAY("Bahasa Melayu", "ms_my"),
	MALTESE("Malti", "mt_mt"),
	LOW_GERMAN("Platdüütsk", "nds_de"),
	DUTCH("Nederlands", "nl_nl"),
	VLAAMS("Dutch, Flemish", "nl_be"),
	NORWEGIAN_NYNORSK("Norsk nynorsk", "nn_no"),
	NORWEGIAN_BOKMÅL("Norsk Bokmål", "no_no‌"),
	NUU_CHAH_NULTH‌("Nuučaan̓uł", "nuk"),
	OCCITAN("Occitan", "oc_fr"),
	OJIBWE‌("Ojibwemowin", "oj_ca"),
	ELFDALIAN("Övdalsk", "ovd"),
	POLISH("Polski", "pl_pl"),
	PORTUGUESE("Português (Portugal)", "pt_pt"),
	BRAZILIAN_PORTUGUESE("Português (Brasil)", "pt_br"),
	QUENYA("Quenya", "qya_aa"),
	ROMANIAN("Română", "ro_ro"),
	RUSSIAN_PRE_REVOLUTIONARY("Дореформенный русскiй (Doreformennɨĭ russkiĭ)", "rpr"),
	RUSSIAN("Русский (Russkiĭ)", "ru_ru"),
	SICILIAN("Sicilianu", "scn"),
	NORTHERN_SAMI("Davvisámegiella", "se_no"),
	SLOVAK("Slovenčina", "sk_sk"),
	SLOVENIAN("Slovenščina", "sl_si"),
	SOMALI("Af-Soomaali", "so_so"),
	ALBANIAN("Shqip", "sq_al"),
	SERBIAN("Српски/Srpski", "sr_sp"),
	SWEDISH("Svenska", "sv_se"),
	ALLGOVIAN_GERMAN("Oschdallgaierisch", "swg"),
	UPPER_SAXON_GERMAN("Säggs'sch", "sxu"),
	SILESIAN("Ślōnskŏ", "szl"),
	TAMIL("தமிழ் (Tamił)", "ta_in"),
	THAI("ภาษาไทย (Phasathay)", "th_th"),
	TAGALOG("Tagalog", "tl_ph"),
	KLINGON("tlhIngan Hol", "tlh_aa"),
	TURKISH("Türkçe", "tr_tr"),
	TATAR("Татарча", "tt_ru"),
	TALOSSAN‌("Talossan", "tzl_tzl"),
	UKRAINIAN("Українська (Ukraïns'ka)", "uk_ua"),
	VALENCIAN("Català (Valencià)", "val_es"),
	VENETIAN("Vèneto", "vec_it"),
	VIETNAMESE("Tiếng Việt", "vi_vn"),
	YIDDISH("ייִדיש (Yidiš)", "yi_de"),
	YORUBA("Yorùbá", "yo_ng"),
	CHINESE_SIMPLIFIED("简体中文 (中国) (Jiǎntǐ Zhōngwén (Zhōngguó))", "zh_cn"),
	CHINESE_TRADITIONAL_HONGKONG("繁體中文 (香港) (Fántǐ Zhōngwén (Xiānggǎng))", "zh_hk"),
	CHINESE_TRADITIONAL_TAIWAN("繁體中文 (台灣) (Fántǐ Zhōngwén (Táiwān))", "zh_tw");
			
	// @formatter:on

	private String name;
	private String locale;
	
	private ELanguage(String name, String locale) {
		this.name = name;
		this.locale = locale;
	}

	public String getName() {
		return name;
	}

	public String getLocale() {
		return locale;
	}

	public static Optional<ELanguage> getFromLocale(String locale) {

		for (ELanguage lang : ELanguage.values())
			if (lang.getLocale().equals(locale))
				return Optional.of(lang);

		if (!locale.contains("_")) {
			for (ELanguage lang : ELanguage.values())
				if (lang.getLocale().split("_")[0].equals(locale))
					return Optional.of(lang);
		}

		return Optional.empty();
	}

}
