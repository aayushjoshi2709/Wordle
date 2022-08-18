package com.example.wordle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // Initial wordlist for the words in the game
    ArrayList<String> arr = new ArrayList<String>(Arrays.asList("aback", "abase", "abate", "abaya", "abbey", "abbot", "abets", "abhor", "abide", "abode", "abort", "about", "above", "abuse", "abuts", "abyss", "ached", "aches", "acids", "acing", "ackee", "acorn", "acres", "acrid", "acted", "actin", "actor", "acute", "adage", "adapt", "added", "adder", "addle", "adept", "adieu", "adios", "adits", "adman", "admin", "admit", "adobe", "adobo", "adopt", "adore", "adorn", "adult", "adzes", "aegis", "aeons", "aerie", "affix", "afire", "afoot", "afore", "after", "again", "agape", "agate", "agave", "agent", "aggro", "agile", "aging", "aglow", "agony", "agora", "agree", "ahead", "ahold", "aided", "aider", "aides", "ailed", "aimed", "aimer", "aioli", "aired", "aisle", "alarm", "album", "alder", "aleph", "alert", "algae", "algal", "alias", "alibi", "alien", "align", "alike", "alive", "alkyd", "alkyl", "allay", "alley", "allot", "allow", "alloy", "allyl", "aloes", "aloft", "aloha", "alone", "along", "aloof", "aloud", "alpha", "altar", "alter", "altos", "alums", "amass", "amaze", "amber", "ambit", "amble", "ambos", "amend", "amide", "amine", "amino", "amiss", "amity", "amnio", "among", "amour", "amped", "ample", "amply", "amuse", "ancho", "angel", "anger", "angle", "angry", "angst", "anima", "anime", "anion", "anise", "ankle", "annas", "annex", "annoy", "annul", "anode", "anole", "antic", "antis", "antsy", "anvil", "aorta", "apace", "apart", "aphid", "apnea", "apple", "apply", "apron", "apses", "apter", "aptly", "aquas", "arbor", "ardor", "areal", "areas", "areca", "arena", "argon", "argot", "argue", "argus", "arias", "arils", "arise", "armed", "armor", "aroma", "arose", "array", "arrow", "arses", "arson", "artsy", "asana", "ascot", "ashen", "ashes", "aside", "asked", "asker", "askew", "aspen", "aspic", "assay", "asses", "asset", "aster", "astir", "asura", "atlas", "atman", "atoll", "atoms", "atone", "atopy", "attic", "audio", "audit", "auger", "aught", "augur", "aunts", "aunty", "aural", "auras", "autos", "auxin", "avail", "avers", "avert", "avian", "avoid", "avows", "await", "awake", "award", "aware", "awash", "awful", "awoke", "axels", "axial", "axils", "axing", "axiom", "axion", "axles", "axons", "azide", "azole", "azure", "babel", "babes", "babka", "backs", "bacon", "baddy", "badge", "badly", "bagel", "baggy", "bails", "bairn", "baits", "baize", "baked", "baker", "bakes", "baldy", "baled", "baler", "bales", "balks", "balky", "balls", "balms", "balmy", "balsa", "banal", "bands", "bandy", "banes", "bangs", "banjo", "banks", "barbs", "bards", "bared", "barer", "bares", "barge", "barks", "barmy", "barns", "baron", "barre", "basal", "based", "baser", "bases", "basic", "basil", "basin", "basis", "basks", "basso", "bassy", "baste", "batch", "bated", "bathe", "baths", "batik", "baton", "batts", "batty", "bawdy", "bawls", "bayed", "bayou", "beach", "beads", "beady", "beaks", "beams", "beamy", "beans", "beard", "bears", "beast", "beats", "beaus", "beaut", "beaux", "bebop", "becks", "beech", "beefs", "beefy", "beeps", "beers", "beery", "beets", "befit", "began", "beget", "begin", "begun", "beige", "being", "belay", "belch", "belie", "belle", "bells", "belly", "below", "belts", "bench", "bends", "bendy", "bento", "bents", "beret", "bergs", "berms", "berry", "berth", "beryl", "beset", "bests", "betas", "betel", "betta", "bevel", "bezel", "bhaji", "bible", "bicep", "biddy", "bided", "bides", "bidet", "bight", "bigot", "bijou", "biked", "biker", "bikes", "biles", "bilge", "bills", "billy", "bimbo", "bindi", "binds", "binge", "bingo", "biome", "biota", "bipod", "birch", "birds", "birth", "bison", "bitch", "biter", "bites", "bitsy", "bitty", "black", "blade", "blame", "bland", "blank", "blare", "blase", "blast", "blaze", "bleak", "bleat", "blebs", "bleed", "bleep", "blend", "bless", "blimp", "blind", "bling", "blini", "blink", "blips", "bliss", "blitz", "bloat", "blobs", "block", "blocs", "blogs", "bloke", "blond", "blood", "bloom", "bloop", "blots", "blown", "blows", "blued", "blues", "bluey", "bluff", "blunt", "blurb", "blurs", "blurt", "blush", "board", "boars", "boast", "boats", "bobby", "bocce", "boche", "boded", "bodes", "boffo", "bogey", "boggy", "bogie", "bogus", "boils", "bolas", "boles", "bolls", "bolts", "bolus", "bombe", "bombs", "bonds", "boned", "boner", "bones", "boney", "bongo", "bongs", "bonks", "bonny", "bonus", "boobs", "booby", "booed", "books", "booms", "boomy", "boons", "boors", "boost", "booth", "boots", "booty", "booze", "boozy", "boppy", "borax", "bored", "borer", "bores", "boric", "borne", "boron", "bosom", "boson", "bossy", "bosun", "botch", "bough", "boule", "bound", "bouts", "bowed", "bowel", "bower", "bowls", "boxed", "boxer", "boxes", "boyar", "boyos", "bozos", "brace", "bract", "brads", "brags", "braid", "brain", "brake", "brand", "brans", "brash", "brass", "brats", "brave", "bravo", "brawl", "brawn", "brays", "braze", "bread", "break", "bream", "breed", "brews", "briar", "bribe", "brick", "bride", "brief", "brier", "brigs", "brims", "brine", "bring", "brink", "briny", "brisk", "brits", "broad", "broch", "broil", "broke", "brome", "bronc", "brood", "brook", "broom", "broth", "brown", "brows", "bruin", "bruit", "brunt", "brush", "brute", "bubba", "bucks", "buddy", "budge", "buffs", "buggy", "bugle", "build", "built", "bulbs", "bulge", "bulks", "bulky", "bulla", "bulls", "bully", "bumps", "bumpy", "bunch", "bunds", "bundt", "bunks", "bunny", "bunts", "buoys", "burbs", "burgs", "burka", "burly", "burns", "burnt", "burps", "burqa", "burro", "burrs", "bursa", "burst", "bused", "buses", "bushy", "busts", "busty", "butch", "butte", "butts", "buxom", "buyer", "buzzy", "bylaw", "byres", "bytes", "byway", "cabal", "cabby", "caber", "cabin", "cable", "cacao", "cache", "cacti", "caddy", "cadet", "cadre", "cafes", "caged", "cages", "cagey", "cairn", "caked", "cakes", "cakey", "calfs", "calif", "calla", "calls", "calms", "calve", "calyx", "camel", "cameo", "campo", "camps", "campy", "canal", "candy", "caned", "canes", "canid", "canna", "canny", "canoe", "canon", "canto", "caped", "caper", "capes", "capon", "capos", "caput", "carat", "carbo", "carbs", "cards", "cared", "carer", "cares", "cargo", "carob", "carol", "carom", "carps", "carry", "carte", "carts", "carve", "cased", "cases", "casks", "caste", "casts", "catch", "cater", "catty", "caulk", "cause", "caved", "caver", "caves", "cavil", "cease", "cecal", "cecum", "cedar", "ceded", "cedes", "ceili", "celeb", "cello", "cells", "celts", "cents", "chads", "chafe", "chaff", "chain", "chair", "chalk", "champ", "chana", "chant", "chaos", "chaps", "chard", "charm", "chars", "chart", "chase", "chasm", "chats", "cheap", "cheat", "check", "cheek", "cheep", "cheer", "chefs", "chemo", "chert", "chess", "chest", "chews", "chewy", "chica", "chick", "chico", "chide", "chief", "child", "chile", "chili", "chill", "chime", "chimp", "china", "chine", "ching", "chino", "chins", "chips", "chirp", "chits", "chive", "chock", "choir", "choke", "chomp", "chops", "chord", "chore", "chose", "chows", "chubs", "chuck", "chuff", "chugs", "chump", "chums", "chunk", "churn", "chute", "cider", "cigar", "cinch", "circa", "cisco", "cited", "cites", "civet", "civic", "civil", "civvy", "clack", "clade", "claim", "clamp", "clams", "clang", "clank", "clans", "claps", "clash", "clasp", "class", "clave", "claws", "clays", "clean", "clear", "cleat", "clefs", "cleft", "clerk", "click", "cliff", "climb", "clime", "cline", "cling", "clink", "clips", "cloak", "clock", "clods", "clogs", "clomp", "clone", "close", "cloth", "clots", "cloud", "clout", "clove", "clown", "clubs", "cluck", "clued", "clues", "clump", "clung", "clunk", "coach", "coals", "coast", "coati", "coats", "cobia", "cobra", "cocci", "cocks", "cocky", "cocoa", "codas", "codec", "coded", "coder", "codes", "codex", "codon", "coeds", "cohos", "coifs", "coils", "coins", "cokes", "colas", "colds", "coles", "colic", "colin", "colon", "color", "colts", "comas", "combo", "combs", "comer", "comes", "comet", "comfy", "comic", "comma", "commo", "compo", "comps", "comte", "conch", "condo", "coned", "cones", "conga", "congo", "conic", "conks", "cooed", "cooks", "cools", "coops", "coopt", "coped", "copes", "copra", "copse", "coral", "cords", "cored", "corer", "cores", "corgi", "corks", "corky", "corms", "corns", "cornu", "corny", "corps", "costs", "cotta", "couch", "cough", "could", "count", "coupe", "coups", "court", "coven", "cover", "coves", "covet", "covey", "cowed", "cower", "cowls", "coyly", "crabs", "crack", "craft", "crags", "cramp", "crams", "crane", "crank", "crape", "craps", "crash", "crass", "crate", "crave", "crawl", "craws", "craze", "crazy", "creak", "cream", "credo", "creed", "creek", "creel", "creep", "creme", "crepe", "crept", "cress", "crest", "crews", "cribs", "crick", "cried", "crier", "cries", "crime", "crimp", "crisp", "crits", "croak", "crock", "crocs", "croft", "crone", "crony", "crook", "croon", "crops", "cross", "croup", "crowd", "crown", "crows", "crude", "cruel", "cruet", "crumb", "cruse", "crush", "crust", "crypt", "cubby", "cubed", "cubes", "cubic", "cubit", "cuddy", "cuffs", "culls", "culpa", "cults", "cumin", "cupid", "cuppa", "curbs", "curds", "cured", "cures", "curia", "curio", "curls", "curly", "curry", "curse", "curve", "curvy", "cushy", "cusps", "cuter", "cutie", "cutis", "cutup", "cycad", "cycle", "cyclo", "cynic", "cysts", "czars", "dacha", "daddy", "dados", "daffy", "daily", "dairy", "daisy", "dales", "dames", "damns", "damps", "dance", "dandy", "dared", "dares", "darks", "darns", "darts", "dashi", "dated", "dater", "dates", "datum", "daubs", "daunt", "davit", "dawns", "dazed", "deals", "dealt", "deans", "dears", "deary", "death", "debit", "debts", "debug", "debut", "decaf", "decal", "decay", "decks", "decor", "decoy", "decry", "deeds", "deems", "deeps", "deers", "defer", "deify", "deign", "deism", "deist", "deity", "dekes", "delay", "delft", "delis", "dells", "delta", "delve", "demon", "demos", "demur", "denim", "dense", "dents", "depot", "depth", "derby", "desks", "deter", "detox", "deuce", "devil", "dewar", "dhikr", "dhows", "dials", "diary", "diced", "dices", "dicey", "dicky", "dicta", "diets", "digit", "diked", "dikes", "dills", "dilly", "dimer", "dimes", "dimly", "dinar", "dined", "diner", "dines", "dingo", "dings", "dingy", "dinks", "dinky", "dinos", "diode", "dippy", "direr", "dirge", "dirty", "disco", "discs", "dishy", "disks", "ditch", "ditsy", "ditto", "ditty", "ditzy", "divan", "divas", "dived", "diver", "dives", "divot", "divvy", "dizzy", "docks", "dodge", "dodgy", "dodos", "doers", "doffs", "doges", "doggy", "dogma", "doing", "doled", "doles", "dolls", "dolly", "dolor", "dolts", "domed", "domes", "donee", "dongs", "donna", "donor", "donut", "dooms", "doomy", "doors", "doozy", "doped", "dopes", "dopey", "dorks", "dorky", "dorms", "dosas", "dosed", "doses", "doted", "dotes", "dotty", "doubt", "dough", "doula", "douse", "doves", "dowdy", "dowel", "dower", "downs", "downy", "dowry", "dowse", "doyen", "dozed", "dozen", "dozer", "dozes", "drabs", "draft", "drags", "drain", "drake", "drama", "drams", "drank", "drape", "drawl", "drawn", "draws", "drays", "dread", "dream", "dreck", "dregs", "dress", "dribs", "dried", "drier", "dries", "drift", "drill", "drily", "drink", "drips", "drive", "droid", "droll", "drone", "drool", "droop", "drops", "dross", "drove", "drown", "drugs", "druid", "drums", "drunk", "drupe", "dryad", "dryer", "dryly", "duals", "ducal", "ducat", "duchy", "ducks", "ducky", "ducts", "dudes", "duels", "duets", "duffs", "dukes", "dulls", "dully", "dulse", "dumbo", "dummy", "dumps", "dumpy", "dunce", "dunes", "dunks", "duomo", "duped", "dupes", "dural", "durum", "dusks", "dusky", "dusts", "dusty", "dutch", "duvet", "dwarf", "dweeb", "dwell", "dwelt", "dyads", "dyers", "dying", "dykes", "eager", "eagle", "eared", "earls", "early", "earns", "earth", "eased", "easel", "easer", "eases", "eaten", "eater", "eaves", "ebbed", "ebony", "ebook", "echos", "eclat", "edema", "edged", "edger", "edges", "edict", "edify", "edits", "eejit", "eerie", "egged", "egret", "eider", "eidos", "eight", "eject", "ejido", "eland", "elbow", "elder", "elect", "elegy", "elide", "elite", "elope", "elude", "elute", "elven", "elves", "email", "embed", "ember", "emcee", "emery", "emirs", "emits", "emote", "empty", "enact", "ended", "endow", "enema", "enemy", "enjoy", "ennui", "enoki", "enrol", "ensue", "enter", "entry", "envoy", "eosin", "epics", "epoch", "epoxy", "equal", "equip", "erase", "erect", "ergot", "erode", "erred", "error", "erupt", "essay", "ether", "ethic", "ethos", "ethyl", "etude", "euros", "evade", "evens", "event", "every", "evict", "evils", "evoke", "ewers", "exact", "exalt", "exams", "excel", "execs", "exert", "exile", "exist", "exits", "expat", "expel", "expos", "extol", "extra", "exude", "exult", "exurb", "eying", "eyrie", "fable", "faced", "facer", "faces", "facet", "facia", "facts", "faded", "fader", "fades", "faery", "fails", "faint", "fairs", "fairy", "faith", "faked", "faker", "fakes", "fakie", "fakir", "falls", "famed", "fancy", "fangs", "fanny", "farce", "fared", "fares", "farms", "farts", "fasts", "fatal", "fated", "fates", "fatso", "fatty", "fatwa", "fault", "fauna", "fauns", "favas", "faves", "favor", "fawns", "faxed", "faxes", "fazed", "fazes", "fears", "feast", "feats", "fecal", "feces", "feeds", "feels", "feign", "feint", "fella", "fells", "felon", "felts", "femme", "femur", "fence", "fends", "feral", "feria", "ferns", "ferny", "ferry", "fests", "fetal", "fetch", "feted", "fetes", "fetid", "fetus", "feuds", "fever", "fewer", "fiats", "fiber", "fibre", "fiche", "ficus", "fiefs", "field", "fiend", "fiery", "fifes", "fifth", "fifty", "fight", "filch", "filed", "filer", "files", "filet", "fills", "filly", "films", "filmy", "filth", "final", "finca", "finch", "finds", "fined", "finer", "fines", "finis", "finks", "fiord", "fired", "fires", "firms", "first", "fishy", "fists", "fitly", "fiver", "fives", "fixed", "fixer", "fixes", "fizzy", "fjord", "flack", "flags", "flail", "flair", "flake", "flaky", "flame", "flank", "flans", "flaps", "flare", "flash", "flask", "flats", "flaws", "flays", "fleas", "fleck", "flees", "fleet", "flesh", "flick", "flier", "flies", "fling", "float", "flood", "floor", "flour", "flown", "flows", "fluid", "flyer", "focal", "focus", "folks", "fonts", "foods", "force", "forms", "forth", "forty", "forum", "found", "frame", "fraud", "fresh", "fried", "fries", "front", "frost", "fruit", "fuels", "fully", "funds", "funny", "gains", "games", "gamma", "gases", "gates", "gauge", "gears", "genes", "genre", "ghost", "giant", "gifts", "girls", "given", "gives", "gland", "glass", "globe", "glory", "gloss", "glove", "glued", "goals", "goats", "going", "goods", "grace", "grade", "grain", "grams", "grand", "grant", "grape", "graph", "grasp", "grass", "grave", "great", "greek", "green", "greet", "grief", "grill", "grind", "grips", "gross", "group", "grove", "grown", "grows", "guard", "guess", "guest", "guide", "guild", "guilt", "habit", "hairs", "halls", "hands", "handy", "hangs", "happy", "harsh", "hated", "hates", "haven", "hawks", "heads", "heard", "heart", "heavy", "hedge", "heels", "hello", "helps", "hence", "herbs", "highs", "hills", "hints", "hired", "hobby", "holds", "holes", "holly", "homes", "honey", "honor", "hooks", "hoped", "hopes", "horns", "horse", "hosts", "hotel", "hours", "house", "hover", "human", "humor", "hurts", "icons", "ideal", "ideas", "idiot", "image", "imply", "inbox", "incur", "index", "indie", "inner", "input", "intro", "issue", "items", "jeans", "jelly", "jewel", "joins", "joint", "jokes", "judge", "juice", "juicy", "jumps", "keeps", "kicks", "kills", "kinda", "kinds", "kings", "knees", "knife", "knock", "knots", "known", "knows", "label", "labor", "lacks", "lakes", "lamps", "lands", "lanes", "large", "laser", "lasts", "later", "laugh", "layer", "leads", "leaks", "learn", "lease", "least", "leave", "legal", "lemon", "level", "lever", "light", "liked", "likes", "limbs", "limit", "lined", "linen", "liner", "lines", "links", "lions", "lists", "lived", "liver", "lives", "loads", "loans", "lobby", "local", "locks", "lodge", "logic", "logos", "looks", "loops", "loose", "lords", "loses", "loved", "lover", "loves", "lower", "loyal", "lucky", "lunar", "lunch", "lungs", "lying", "macro", "magic", "major", "maker", "makes", "males", "maple", "march", "marks", "marry", "masks", "match", "mates", "maths", "matte", "maybe", "mayor", "meals", "means", "meant", "meats", "medal", "media", "meets", "melee", "menus", "mercy", "merge", "merit", "merry", "messy", "metal", "meter", "metro", "micro", "midst", "might", "miles", "minds", "mines", "minor", "minus", "mixed", "mixer", "mixes", "model", "modem", "modes", "moist", "money", "month", "moral", "motor", "mount", "mouse", "mouth", "moved", "moves", "movie", "music", "myths", "nails", "naked", "named", "names", "nasal", "nasty", "naval", "needs", "nerve", "never", "newer", "newly", "nexus", "nicer", "niche", "night", "ninja", "ninth", "noble", "nodes", "noise", "noisy", "norms", "north", "notch", "noted", "notes", "novel", "nurse", "nylon", "oasis", "occur", "ocean", "offer", "often", "older", "olive", "omega", "onion", "onset", "opens", "opera", "opted", "optic", "orbit", "order", "organ", "other", "ought", "ounce", "outer", "owned", "owner", "oxide", "packs", "pages", "pains", "paint", "pairs", "panel", "panic", "pants", "paper", "parks", "parts", "party", "pasta", "paste", "patch", "paths", "patio", "pause", "peace", "peach", "peaks", "pearl", "pedal", "peers", "penis", "penny", "perks", "pests", "petty", "phase", "phone", "photo", "piano", "picks", "piece", "piles", "pills", "pilot", "pinch", "pipes", "pitch", "pixel", "pizza", "place", "plain", "plane", "plans", "plant", "plate", "plays", "plaza", "plots", "plugs", "poems", "point", "poker", "polar", "poles", "polls", "pools", "porch", "pores", "ports", "posed", "poses", "posts", "pouch", "pound", "power", "press", "price", "pride", "prime", "print", "prior", "prize", "probe", "promo", "prone", "proof", "props", "proud", "prove", "proxy", "psalm", "pulls", "pulse", "pumps", "punch", "pupil", "puppy", "purse", "queen", "query", "quest", "queue", "quick", "quiet", "quilt", "quite", "quote", "races", "racks", "radar", "radio", "rails", "rainy", "raise", "rally", "ranch", "range", "ranks", "rapid", "rated", "rates", "ratio", "razor", "reach", "react", "reads", "ready", "realm", "rebel", "refer", "reign", "relax", "relay", "renal", "renew", "reply", "reset", "resin", "retro", "rider", "rides", "ridge", "rifle", "right", "rigid", "rings", "rinse", "risen", "rises", "risks", "risky", "rival", "river", "roads", "robot", "rocks", "rocky", "rogue", "roles", "rolls", "roman", "rooms", "roots", "ropes", "roses", "rough", "round", "route", "royal", "rugby", "ruins", "ruled", "ruler", "rules", "rural", "sadly", "safer", "salad", "sales", "salon", "sandy", "satin", "sauce", "saved", "saves", "scale", "scalp", "scans", "scare", "scarf", "scary", "scene", "scent", "scoop", "scope", "score", "scout", "scrap", "screw", "seals", "seams", "seats", "seeds", "seeks", "seems", "sells", "sends", "sense", "serum", "serve", "setup", "seven", "sewer", "shade", "shaft", "shake", "shall", "shame", "shape", "share", "shark", "sharp", "sheep", "sheer", "sheet", "shelf", "shell", "shift", "shine", "shiny", "ships", "shirt", "shock", "shoes", "shook", "shoot", "shops", "shore", "short", "shots", "shown", "shows", "sides", "siege", "sight", "sigma", "signs", "silly", "since", "sites", "sixth", "sized", "sizes", "skies", "skill", "skins", "skirt", "skull", "slate", "slave", "sleek", "sleep", "slept", "slice", "slide", "slope", "slots", "small", "smart", "smell", "smile", "smoke", "snack", "snake", "sneak", "socks", "soils", "solar", "solid", "solve", "songs", "sonic", "sorry", "sorts", "souls", "sound", "south", "space", "spare", "spark", "speak", "specs", "speed", "spell", "spend", "spent", "sperm", "spice", "spicy", "spike", "spine", "spite", "split", "spoke", "spoon", "sport", "spots", "spray", "spurs", "squad", "stack", "staff", "stage", "stain", "stake", "stamp", "stand", "stark", "stars", "start", "state", "stats", "stays", "steak", "steal", "steam", "steel", "steep", "steer", "stems", "steps", "stick", "stiff", "still", "stock", "stole", "stone", "stood", "stool", "stops", "store", "storm", "story", "stove", "strap", "straw", "strip", "stuck", "study", "stuff", "style", "sucks", "sugar", "suite", "suits", "sunny", "super", "surge", "sushi", "swear", "sweat", "sweet", "swept", "swift", "swing", "swiss", "sword", "syrup", "table", "taken", "takes", "tales", "talks", "tanks", "tapes", "tasks", "taste", "tasty", "taxes", "teach", "teams", "tears", "teens", "teeth", "tells", "tempo", "tends", "tenth", "tents", "terms", "tests", "texts", "thank", "theft", "their", "theme", "there", "these", "thick", "thief", "thigh", "thing", "think", "third", "those", "three", "threw", "throw", "thumb", "tiger", "tight", "tiles", "timer", "times", "tired", "tires", "title", "toast", "today", "token", "tones", "tools", "tooth", "topic", "torch", "total", "touch", "tough", "tours", "towel", "tower", "towns", "toxic", "trace", "track", "tract", "trade", "trail", "train", "trait", "trans", "traps", "trash", "treat", "trees", "trend", "trial", "tribe", "trick", "tried", "tries", "trips", "trout", "truck", "truly", "trump", "trunk", "trust", "truth", "tubes", "tumor", "tuned", "tunes", "turbo", "turns", "tutor", "tweet", "twice", "twins", "twist", "types", "tyres", "ultra", "uncle", "under", "union", "unite", "units", "unity", "until", "upper", "upset", "urban", "urged", "urine", "usage", "users", "using", "usual", "vague", "valid", "value", "valve", "vapor", "vault", "vegan", "veins", "vents", "venue", "verse", "video", "views", "villa", "vinyl", "viral", "virus", "visas", "visit", "vital", "vivid", "vocal", "vodka", "voice", "volts", "voted", "voter", "votes", "wages", "wagon", "waist", "walks", "walls", "wants", "warns", "waste", "watch", "water", "watts", "waves", "wears", "weeds", "weeks", "weigh", "weird", "wells", "welsh", "whale", "wheat", "wheel", "where", "which", "while", "white", "whole", "whose", "wider", "widow", "width", "winds", "wines", "wings", "wiped", "wired", "wires", "witch", "wives", "woman", "women", "woods", "words", "works", "world", "worms", "worry", "worse", "worst", "worth", "would", "wound", "wrath", "wrist", "write", "wrong", "wrote", "yacht", "yards", "years", "yeast", "yield", "young", "yours", "youth", "yummy", "zones", "About", "Alert", "Argue", "Beach", "Above", "Alike", "Arise", "Began", "Abuse", "Alive", "Array", "Begin", "Actor", "Allow", "Aside", "Begun", "Acute", "Alone", "Asset", "Being", "Admit", "Along", "Audio", "Below", "Adopt", "Alter", "Audit", "Bench", "Adult", "Among", "Avoid", "Billy", "After", "Anger", "Award", "Birth", "Again", "Angle", "Aware", "Black", "Agent", "Angry", "Badly", "Blame", "Agree", "Apart", "Baker", "Blind", "Ahead", "Apple", "Bases", "Block", "Alarm", "Apply", "Basic", "Blood", "Album", "Arena", "Basis", "Board", "Boost", "Buyer", "China", "Cover", "Booth", "Cable", "Chose", "Craft", "Bound", "Calif", "Civil", "Crash", "Brain", "Carry", "Claim", "Cream", "Brand", "Catch", "Class", "Crime", "Bread", "Cause", "Clean", "Cross", "Break", "Chain", "Clear", "Crowd", "Breed", "Chair", "Click", "Crown", "Brief", "Chart", "Clock", "Curve", "Bring", "Chase", "Close", "Cycle", "Broad", "Cheap", "Coach", "Daily", "Broke", "Check", "Coast", "Dance", "Brown", "Chest", "Could", "Dated", "Build", "Chief", "Count", "Dealt", "Built", "Child", "Court", "Death", "Debut", "Entry", "Forth", "Group", "Delay", "Equal", "Forty", "Grown", "Depth", "Error", "Forum", "Guard", "Doing", "Event", "Found", "Guess", "Doubt", "Every", "Frame", "Guest", "Dozen", "Exact", "Frank", "Guide", "Draft", "Exist", "Fraud", "Happy", "Drama", "Extra", "Fresh", "Harry", "Drawn", "Faith", "Front", "Heart", "Dream", "False", "Fruit", "Heavy", "Dress", "Fault", "Fully", "Hence", "Drill", "Fiber", "Funny", "Henry", "Drink", "Field", "Giant", "Horse", "Drive", "Fifth", "Given", "Hotel", "Drove", "Fifty", "Glass", "House", "Dying", "Fight", "Globe", "Human", "Eager", "Final", "Going", "Ideal", "Early", "First", "Grace", "Image", "Earth", "Fixed", "Grade", "Index", "Eight", "Flash", "Grand", "Inner", "Elite", "Fleet", "Grant", "Input", "Empty", "Floor", "Grass", "Issue", "Enemy", "Fluid", "Great", "Irony", "Enjoy", "Focus", "Green", "Juice", "Enter", "Force", "Gross", "Joint", "Jones", "Links", "Media", "Newly", "Judge", "Lives", "Metal", "Night", "Known", "Local", "Might", "Noise", "Label", "Logic", "Minor", "North", "Large", "Loose", "Minus", "Noted", "Laser", "Lower", "Mixed", "Novel", "Later", "Lucky", "Model", "Nurse", "Laugh", "Lunch", "Money", "Occur", "Layer", "Lying", "Month", "Ocean", "Learn", "Magic", "Moral", "Offer", "Lease", "Major", "Motor", "Often", "Least", "Maker", "Mount", "Order", "Leave", "March", "Mouse", "Other", "Legal", "Maria", "Mouth", "Ought", "Level", "Match", "Movie", "Paint", "Lewis", "Maybe", "Music", "Panel", "Light", "Mayor", "Needs", "Paper", "Limit", "Meant", "Never", "Party", "Peace", "Power", "Radio", "Round", "Peter", "Press", "Raise", "Route", "Phase", "Price", "Range", "Royal", "Phone", "Pride", "Rapid", "Rural", "Photo", "Prime", "Ratio", "Scale", "Piece", "Print", "Reach", "Scene", "Pilot", "Prior", "Ready", "Scope", "Pitch", "Prize", "Refer", "Score", "Place", "Proof", "Right", "Sense", "Plain", "Proud", "Rival", "Serve", "Plane", "Prove", "River", "Seven", "Plant", "Queen", "Robin", "Shall", "Plate", "Quick", "Roger", "Shape", "Point", "Quiet", "Roman", "Share", "Pound", "Quite", "Rough", "Sharp", "Sheet", "Spare", "Style", "Times", "Shelf", "Speak", "Sugar", "Tired", "Shell", "Speed", "Suite", "Title", "Shift", "Spend", "Super", "Today", "Shirt", "Spent", "Sweet", "Topic", "Shock", "Split", "Table", "Total", "Shoot", "Spoke", "Taken", "Touch", "Short", "Sport", "Taste", "Tough", "Shown", "Staff", "Taxes", "Tower", "Sight", "Stage", "Teach", "Track", "Since", "Stake", "Teeth", "Trade", "Sixth", "Stand", "Terry", "Train", "Sixty", "Start", "Texas", "Treat", "Sized", "State", "Thank", "Trend", "Skill", "Steam", "Theft", "Trial", "Sleep", "Steel", "Their", "Tried", "Slide", "Stick", "Theme", "Tries", "Small", "Still", "There", "Truck", "Smart", "Stock", "These", "Truly", "Smile", "Stone", "Thick", "Trust", "Smith", "Stood", "Thing", "Truth", "Smoke", "Store", "Think", "Twice", "Solid", "Storm", "Third", "Under", "Solve", "Story", "Those"));
    // Used to store user input
    private final char[][] container = new char[5][5];
    // Represents the current guessed word
    private String currentWord;
    // Counter used to keep track of current row and column
    // Score represents user score
    private int counteri = 0, counterj = 0, score = 0;
    // Dialog used for customised dialog boxes
    private Dialog dialog;
    // Textview to see user score
    private TextView scoreView;
    // Stores the ids of the key pressed to fill current row
    private int[] ids = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hides the application action bar at the top
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        // Initiate a dialog box object later user for showing user their winnings
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.alert_dialog_layout);
        // Initiate the score box object
        scoreView = (TextView) findViewById(R.id.score);
        init();
    }

    // Used to set the rounded border style to all the text views in the grid
    // Also calls clear data function
    private void init(){
        for(int i = 0; i < 5;i++) {
            for (int j = 0; j < 5; j++) {
                int number = (i * 5 + j) + 1;
                TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
                tv.setText(container[i][j] + "");
                // Applies rounded border to the text views
                tv.setCompoundDrawables(ContextCompat.getDrawable(getApplicationContext(),R.drawable.rounded_corner2),null,null,null);
                tv.setTextColor(Color.WHITE);
            }
        }
        // Used to clear data
        clearData();
    }
    // Used to set the data to the grid
    private void printToGrid(int i, int j){
        int number = (i * 5 + j) + 1;
        TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
        tv.setText(container[counteri][j] + "");
    }
    // Clears all the field for a new game
    private void clearData(){
        // Sets i, j to 0
        counteri = 0;
        counterj = 0;
        // Chooses a random word which user will try to guess When playing
        int randomNumber = (int)Math.floor(Math.random()*(arr.size()-0+1)+0);
        currentWord = arr.get(randomNumber).toUpperCase();
        // Sets the submit button to the disabled state
        Button submitButton = findViewById(R.id.submit);
        submitButton.setEnabled(false);
        // Empty the user input container
        for(int i = 0; i < 5;i++){
            for(int j = 0; j < 5;j++){
                container[i][j] = ' ';
            }
        }
        // Sets the color to the text views back to the starting color (#ffcccc)
        for(int i = 0; i < 5;i++) {
            for (int j = 0; j < 5; j++) {
                int number = (i * 5 + j) + 1;
                TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
                tv.setText(container[i][j] + "");
                Drawable tvBackground = tv.getBackground();
                tvBackground = DrawableCompat.wrap(tvBackground);
                DrawableCompat.setTint(tvBackground, Color.parseColor("#ffcccc"));
                tv.setBackground(tvBackground);
            }
        }
        // Sets all the disabled key buttons to enabled state again
        for(int i = 1; i <= 26;i++) {
            Button btn = (Button) findViewById(getResources().getIdentifier("button" + i, "id", getPackageName()));
            btn.setEnabled(true);
        }
    }
    // Code for the working of the backspace button
    public void backspace(View view){
        Button submitButton = findViewById(R.id.submit);
        // Prevent backspace action when no characters in row
        if(counterj != 0){
            counterj--;
            container[counteri][counterj] = ' ';
            printToGrid(counteri, counterj);
        }
        // Set submit button text "NOT A WORD" to "SUBMIT" again if the user have entered wrong word previously
        submitButton.setText("SUBMIT");
        // Set submit button state to enabled if it is disabled
        submitButton.setEnabled(false);
    }
    // Action to do when user hits the skip button
    public void skip(View view){
        // Just clear data
        clearData();
    }
    // Check what user have entered is a word or not
    private boolean isWord(){
        String s ="";
        for(int j = 0; j < 5;j++)
            s = s + (container[counteri][j] +"");
        if(arr.contains(s.toLowerCase()))
            return true;
        else
            return false;
    }
    // Function to get button presses
    public void buttonPress(View view){
        Button submitButton = findViewById(R.id.submit);
        // Gets the id of the button pressed
        int id = view.getId();
        // Stores that id for coloring the rows according to the correctness of the word
        ids[counterj] = id;
        // Gets the entered character from the button pressed
        Button but = findViewById(id);
        char c = but.getText().toString().charAt(0);
        // If the row is not filled just append the word to the end
        if(counterj < 5){
            container[counteri][counterj] = c;
            printToGrid(counteri, counterj);
            counterj++;
        }
        // If row is completely filled enable submit button but first check weather it is a valid word or not
        if(counterj == 5){

            if(isWord())
                // If the word is valid enable submit button
                submitButton.setEnabled(true);
            else
                // Else set the submit button text to "NOT A WORD"
                submitButton.setText("Not a Word");
        }
    }
    // Used to build a alert if user wins or looses
    private void buildAlert(String msg1, boolean win){
        // Sets the correct word to the text views in the alert box
        for (int j = 1; j <= 5; j++) {
            TextView tv = dialog.findViewById(getResources().getIdentifier("textView_dialog_" + j, "id", getPackageName()));
            tv.setText(currentWord.charAt(j-1) + "");
        }
        // sets the message You Win / You Lose
        TextView text = (TextView) dialog.findViewById(R.id.dialog_status);
        text.setText(msg1);
        // Sets the background color of the imageview in alert depending on winning or loosing of the user
        ImageView imageView = (ImageView) dialog.findViewById(R.id.imageView);
        if(win == true){
            imageView.setBackgroundColor(Color.parseColor("#7CFC00"));
        }else{
            imageView.setBackgroundColor(Color.parseColor("#FF5733"));
        }
        // Adds yes / no buttons for user wanting to play the game again or not
        Button dialogButtonYes = (Button) dialog.findViewById(R.id.dialog_button_yes);
        dialogButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clears the grid for new game
                clearData();
                // Closes the dialog box
                dialog.dismiss();
            }
        });
        Button dialogButtonNo = (Button) dialog.findViewById(R.id.dialog_button_no);
        dialogButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Closes the dialog box
                dialog.dismiss();
                // Exits the activity
                finishAffinity();
                System.exit(0);
            }
        });
        // Shows the dialog box to the user
        dialog.show();
    }
    // Function used to update the score if user wins
    private void updateScore(){
        scoreView.setText("Your Score: " + score);
    }
    // Function to change color of a circular views
    void changeColor(View view, String color){
        // Gets the background color property for that particular textview
        Drawable viewBackground = view.getBackground();
        viewBackground = DrawableCompat.wrap(viewBackground);
        // Change the color of the view and set it to given color
        DrawableCompat.setTint(viewBackground, Color.parseColor(color));
        view.setBackground(viewBackground);
    }
    // Function to be executed when user presses submit button
    public void submit(View view){
        Button submitButton = findViewById(R.id.submit);
        // Counter to count the no of correct letters entered by user in correct place
        int count = 0;
        // Checks the user provided word for correctness
        for(int j = 0; j < 5;j++) {
            // Gets the text view having jth letter of word
            int number = (counteri * 5 + j) + 1;
            TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
            // Get the button having jth letter
            Button but = findViewById(ids[j]);
            // Gets the character entered in that textview
            char c = tv.getText().toString().charAt(0);
            if(currentWord.charAt(j) == c){
                // If the character entered in the textview is present in the currentWord and position of that character in currentWord = position of that character in current row
                // Set the color of the text view containing that character to green color shade (#76FF03)
                changeColor(tv, "#76FF03");
                count++;
            }else{
                int i = 0;
                for(i = 0; i < 5;i++){
                    if(currentWord.charAt(i) == c){
                        // If the character entered in the textview is present in the currentWord but the position of that character in currentWord != position of that character in current row
                        // Set the color of the text view containing that character to yellow color (#FFA000)
                        changeColor(tv, "#FFA000");
                        break;
                    }
                }
                if(i == 5) {
                    // If the character entered in the textview is not present in the currentWord disable the button corresponding to character
                    // and set the color of the text view containing that character to black color ("#D1C4E9")
                    changeColor(tv, "#D1C4E9");
                    but.setEnabled(false);
                }
            }
        }
        // If count == 5 user wins
        if(count==5) {
            // Shows user winning alert
            buildAlert("You Win", true);
            // Updates the user score
            score++;
            updateScore();
        }else{
            // Sets the counters for taking input in the next row and column
            counteri++;
            counterj = 0;
            // If count != 5 and the grid is filled user loses
            if(counteri == 5)
                buildAlert("You Lose", false);
            // Sets the submit button to disabled state until user enter a valid word in next Row
            submitButton.setEnabled(false);
        }
    }
}