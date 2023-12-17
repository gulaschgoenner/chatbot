import java.util.*;

public class Utils {
    public static List<String> verabschiedungen = List.of("tschüss", "bye", "wiedersehen");
    public static List<String> ja = List.of("ja", "yes");
    public static List<String> nein = List.of("nein", "no", "nicht");
    public static Map<String, String> solutions;

    public static String standardSolution = """
            Ich konnte leider keine spezifische Lösung finden, hier sind einige allgemeine Hilfen:
            Neustart des Computers:
            Oft können viele Probleme durch einen einfachen Neustart behoben werden. Dies ermöglicht es dem Betriebssystem und den Programmen, sich neu zu initialisieren.
                        
            Aktualisierung von Software und Treibern:
            Stelle sicher, dass sowohl das Betriebssystem als auch die verwendeten Programme auf dem neuesten Stand sind. Dies schließt auch die Aktualisierung von Treibern für Hardwarekomponenten ein.
                        
            Überprüfung auf Viren und Malware:
            Führe regelmäßige Viren- und Malware-Scans durch, um sicherzustellen, dass dein System nicht von schädlicher Software infiziert ist.
                        
            Neuinstallation von Software:
            Wenn ein bestimmtes Programm Probleme verursacht, versuche es zu deinstallieren und neu zu installieren.
                        
            Online-Foren und Support durchsuchen:
            Durchsuche Foren und Support-Websites, um zu sehen, ob andere Benutzer ähnliche Probleme hatten und Lösungen gefunden haben.
                        
            Professionelle Hilfe in Anspruch nehmen:
            Wenn du nicht in der Lage bist, das Problem selbst zu lösen, ziehe in Erwägung, professionelle Hilfe in Anspruch zu nehmen. Dies könnte den Kontakt mit dem technischen Support des Herstellers oder einem Fachmann vor Ort einschließen.
            """;

    static {
        HashMap<String, String> sols = new HashMap<>();
        sols.put("ja-neue-hardware", """
                Inkompatibilität der Hardware:
                Es besteht die Möglichkeit, dass die neue Hardware nicht mit der vorhandenen Hardware oder dem System inkompatibel ist. Dies könnte zu Konflikten führen und das reibungslose Funktionieren des Geräts beeinträchtigen.
                                
                Treiberprobleme:
                Neue Hardware erfordert oft spezifische Treiber, um ordnungsgemäß zu funktionieren. Wenn die Treiber nicht korrekt installiert sind oder veraltet sind, kann dies zu Fehlfunktionen führen.
                                
                Montagefehler:
                Fehlerhafte Installation der neuen Hardware kann zu physischen Problemen führen. Das könnte zum Beispiel falsches Anschließen von Kabeln, Lockern von Verbindungen oder Beschädigungen an anderen Komponenten umfassen.
                                
                Ressourcenkonflikte:
                Die neue Hardware könnte um die gleichen Ressourcen konkurrieren, die auch von anderen Geräten oder Komponenten genutzt werden. Dies kann zu Konflikten führen und die Stabilität des Systems beeinträchtigen.
                                
                Stromversorgung:
                Eine unzureichende Stromversorgung könnte dazu führen, dass die neue Hardware nicht ordnungsgemäß funktioniert. Es ist wichtig sicherzustellen, dass die Stromversorgung den Anforderungen der neuen Hardware entspricht.
                                
                BIOS/UEFI-Einstellungen:
                Änderungen in der Hardware können eine Anpassung der BIOS/UEFI-Einstellungen erfordern. Falsche Einstellungen können zu Problemen führen. Dies betrifft insbesondere Einstellungen wie Bootreihenfolge, RAM-Frequenz oder CPU-Konfiguration.
                                
                Defekte Hardware:
                Es besteht immer die Möglichkeit, dass die neue Hardware defekt ist. In diesem Fall könnte sie selbst das Problem darstellen und sollte möglicherweise durch eine funktionierende Einheit ersetzt werden.
                                
                Softwarekonflikte:
                Manchmal kann die Installation neuer Hardware zu Softwarekonflikten führen. Dies könnte durch bereits installierte Programme oder Betriebssysteme verursacht werden. 
                 """);
        sols.put("ja-geraeusche", """
                Überprüfe die Lüfter:
                Lüfter sind oft die häufigste Quelle für ungewöhnliche Geräusche. Überprüfe alle Lüfter in deinem System, einschließlich des CPU-Kühlers, Gehäuselüfters und des Netzteillüfters. Stelle sicher, dass keine Kabel die Lüfterblätter blockieren, und reinige sie gegebenenfalls von Staub.
                                
                Überprüfe die Festplatte:
                Festplatten können Geräusche verursachen, wenn sie mechanische Probleme haben. Lausche auf Klackern oder Schleifgeräusche. In diesem Fall könnte die Festplatte defekt sein oder kurz vor einem Ausfall stehen. Sichere deine Daten sofort und ersetze die Festplatte.
                                
                Prüfe das optischen Laufwerk (sofern vorhanden:
                Wenn dein Computer über ein optisches Laufwerk verfügt, könnte ein darin steckendes Fremdkörper Geräusche verursachen. Überprüfe den Schacht, um sicherzustellen, dass er leer ist.
                               
                Netzteil überprüfen:
                Das Netzteil kann ebenfalls Geräusche verursachen. Hörst du ein Surren oder Brummen? Wenn ja, könnte das Netzteil die Quelle sein. In diesem Fall wäre ein Austausch des Netzteils notwendig.
                                
                Grafikkarte überprüfen:
                Wenn die Grafikkarte mit einem Lüfter ausgestattet ist, könnte auch dieser Geräusche verursachen. Stelle sicher, dass die Grafikkarte richtig im Slot sitzt und dass der Lüfter frei von Hindernissen ist.
                                
                Andere Hardwarekomponenten überprüfen:
                Schau nach, ob alle anderen Hardwarekomponenten, wie RAM-Module oder Erweiterungskarten, fest und sicher im Motherboard sitzen.
                                
                Achte auf elektrische Entladungen:
                Manchmal können elektrische Entladungen ungewöhnliche Geräusche verursachen. Stelle sicher, dass alle Kabel ordnungsgemäß angeschlossen sind und keine losen Verbindungen vorhanden sind.
                                
                Fremdgeräusche eliminieren:
                Teste den PC in einer ruhigen Umgebung, um sicherzustellen, dass die Geräusche nicht von externen Quellen wie anderen elektronischen Geräten oder Lüftungssystemen stammen.
                """);
        sols.put("flackern", """
                Überprüfe die Verbindungskabel:
                Stelle sicher, dass alle Kabel, insbesondere das Stromkabel und das Videokabel (HDMI, DVI, VGA, DisplayPort), ordnungsgemäß angeschlossen sind und keine Beschädigungen aufweisen. Ein lockerer Stecker oder ein beschädigtes Kabel kann zu Flackern führen.
                                
                Ändere die Bildwiederholrate:
                Öffne die Anzeigeeinstellungen auf deinem Computer und überprüfe die eingestellte Bildwiederholrate. Versuche, eine niedrigere Bildwiederholrate auszuwählen, um zu sehen, ob das Flackern verschwindet. Normalerweise beträgt die Bildwiederholrate 60 Hz, aber du könntest auch 59 Hz oder 50 Hz ausprobieren.
                                
                Aktualisiere die Grafiktreiber:
                Veraltete oder fehlerhafte Grafiktreiber können zu Bildschirmflackern führen. Gehe auf die Website des Herstellers deiner Grafikkarte, lade die neuesten Treiber herunter und installiere sie.
                                
                Starte im abgesicherten Modus:
                Starte deinen Computer im abgesicherten Modus, um festzustellen, ob das Bildschirmflackern weiterhin auftritt. Wenn nicht, könnte ein installiertes Programm oder Treiber das Problem verursachen.
                                
                Deaktiviere Hardwarebeschleunigung:
                In einigen Anwendungen, wie Webbrowsern, kannst du die Hardwarebeschleunigung deaktivieren. Dies kann helfen, wenn das Flackern in bestimmten Anwendungen auftritt.
                                
                Überprüfe auf Magnetfelder und elektronische Störungen:                
                Stelle sicher, dass keine magnetischen Felder in der Nähe des Monitors sind, da diese zu Flackern führen können. Elektronische Störungen von anderen elektronischen Geräten könnten ebenfalls ein Problem sein.
                                
                Ändere die Bildschirmauflösung:               
                Experimentiere mit verschiedenen Bildschirmauflösungen, um zu sehen, ob das Flackern auftritt, wenn du die Auflösung änderst.
                                
                Hardwaretest:
                Überprüfe, ob das Flackern auch bei einem anderen Monitor oder an einem anderen Computer auftritt. Das hilft festzustellen, ob das Problem beim Monitor oder beim Computer liegt.
                                
                BIOS/UEFI-Einstellungen überprüfen:
                Manchmal können Einstellungen im BIOS oder UEFI des Computers das Bildschirmflackern beeinflussen. Aktualisiere das BIOS/UEFI auf die neueste Version und überprüfe die Einstellungen.
                """);
        sols.put("bild-gestoppt", """
                Neustart des Computers:
                Ein einfacher Neustart kann oft vorübergehende Probleme beheben. Starte deinen Computer neu und prüfe, ob das Problem weiterhin besteht.
                                
                Überprüfe auf Überhitzung:
                Überhitzung kann zu Standbildern führen. Stelle sicher, dass Lüfter und Kühlkörper sauber sind und ordnungsgemäß funktionieren. Du kannst auch Überwachungstools verwenden, um die Temperaturen deiner Hardware zu überprüfen.
                                
                Aktualisiere Treiber:
                Veraltete oder fehlerhafte Treiber können zu Standbildern führen. Überprüfe, ob es Aktualisierungen für deine Grafikkarten-, Chipsatz- und Netzwerktreiber gibt, und installiere sie gegebenenfalls.
                                
                Sicherheitssoftware überprüfen:
                Manchmal können Konflikte mit Sicherheitssoftware, wie Antivirenprogrammen, zu Problemen führen. Überprüfe die Einstellungen deiner Sicherheitssoftware oder versuche, sie vorübergehend zu deaktivieren, um festzustellen, ob dies das Problem löst.
                                
                Überprüfe auf Malware:
                Schädliche Software kann zu Stabilitätsproblemen führen. Führe eine gründliche Überprüfung auf Malware durch, um sicherzustellen, dass dein System sauber ist.
                                
                Windows-Ereignisanzeige überprüfen:
                Schau in die Windows-Ereignisanzeige, um nach Fehlermeldungen oder Warnungen zu suchen. Diese können Hinweise darauf geben, was das Einfrieren verursacht.
                                
                Hardwaretests durchführen:
                Überprüfe deine Hardware auf Fehler. Du kannst Diagnosetools verwenden, um RAM, Festplatte und andere Komponenten zu testen. Ein defektes Hardwareteil kann zu Standbildern führen.
                                
                Prüfe auf Hintergrundprozesse:
                Zu viele im Hintergrund laufende Prozesse können die Leistung beeinträchtigen. Überprüfe den Task-Manager, um zu sehen, ob bestimmte Anwendungen viele Ressourcen verbrauchen.
                                
                Windows-Updates installieren:
                Stelle sicher, dass Windows und alle Treiber auf dem neuesten Stand sind, indem du die neuesten Updates installierst.
                """);
        sols.put("schwarzbild", """
                Überprüfe die Verbindungskabel:
                Stelle sicher, dass alle Kabel, insbesondere das Stromkabel und das Video-/Monitor-Kabel (HDMI, DVI, VGA, DisplayPort), ordnungsgemäß angeschlossen sind. Ein lockerer Stecker oder ein beschädigtes Kabel kann zu schwarzen Bildern führen.
                                
                Teste mit einem anderen Monitor/Kabel:
                Versuche, einen anderen Monitor oder ein anderes Video-/Monitor-Kabel zu verwenden, um auszuschließen, dass das Problem beim Monitor oder Kabel liegt. Dadurch kannst du feststellen, ob die Ursache bei der Hardware oder bei den Verbindungen liegt.
                                
                Prüfe die Helligkeitseinstellungen am Monitor:
                Manchmal kann eine falsche Einstellung der Helligkeit oder Kontrast am Monitor zu scheinbar schwarzen Bildern führen. Überprüfe die Einstellungen am Monitor selbst.
                                
                Neustart des Computers:
                Führe einen Neustart deines Computers durch. Einige Softwareprobleme können durch einen einfachen Neustart behoben werden.
                                
                Überprüfe die Grafikeinstellungen:
                Gehe zu den Anzeigeeinstellungen deines Betriebssystems und überprüfe die Grafikeinstellungen. Stelle sicher, dass die Auflösung und Aktualisierungsrate korrekt eingestellt sind.
                                
                Aktualisiere die Grafiktreiber:
                Veraltete oder fehlerhafte Grafiktreiber können zu Problemen führen. Aktualisiere deine Grafiktreiber auf die neueste Version, die vom Hersteller bereitgestellt wird.
                                
                Überprüfe auf Malware:
                Schadsoftware kann die Funktionalität deines Computers beeinträchtigen. Führe eine umfassende Überprüfung auf Malware durch, um sicherzustellen, dass dein System sauber ist.
                                
                BIOS/UEFI-Einstellungen überprüfen:
                Manchmal können Einstellungen im BIOS/UEFI deines Computers Probleme verursachen. Stelle sicher, dass die Einstellungen korrekt sind und aktualisiere das BIOS/UEFI gegebenenfalls.
                                
                Hardwaretests durchführen:
                Überprüfe deine Hardware auf Fehler. Diagnosetools können verwendet werden, um RAM, Festplatte und andere Komponenten zu testen.
                """);
        sols.put("fehlerteil-unbekannt", """
                Inkompatibilität der Hardware:
                Wenn die neue Hardware nicht mit der vorhandenen Hardware oder dem Betriebssystem kompatibel ist, kann dies zu Konflikten führen und den PC daran hindern, ordnungsgemäß zu starten.
                                
                Fehlerhafte Installation:
                Fehlerhafte Installation der neuen Hardware, wie das falsche Einsetzen von Komponenten, unzureichende Verbindungen oder beschädigte Kabel, kann zu Fehlfunktionen führen.
                                
                Treiberprobleme:
                In vielen Fällen erfordert neue Hardware spezifische Treiber, um ordnungsgemäß zu funktionieren. Wenn diese Treiber nicht korrekt installiert sind oder veraltet sind, kann dies zu Problemen führen.
                               
                Konflikte mit bestehender Hardware:
                Die neue Hardware könnte Ressourcen wie IRQs (Interrupt Request), DMA-Kanäle oder I/O-Adressen mit vorhandener Hardware teilen, was zu Konflikten führen kann.
                                
                Netzteilprobleme:
                Eine unzureichende Stromversorgung durch das Netzteil kann zu Funktionsstörungen führen. Überprüfe, ob das Netzteil genügend Leistung für die neue Hardware bereitstellt.
                                
                BIOS/UEFI-Einstellungen:
                Falsche Einstellungen im BIOS oder UEFI können die Funktionalität beeinträchtigen. Stelle sicher, dass die Einstellungen den Anforderungen der neuen Hardware entsprechen.
                                
                Defekte Hardware:
                Es besteht die Möglichkeit, dass die neue Hardware selbst defekt ist. In diesem Fall könnte sie das gesamte System beeinträchtigen.
                                
                Firmware-Kompatibilität:
                Überprüfe, ob die Firmware auf dem Motherboard (z.B. BIOS oder UEFI) die neue Hardware unterstützt. Ein veraltetes BIOS kann zu Inkompatibilitäten führen.
                                
                RAM-Kompatibilität:
                Neue RAM-Module müssen mit dem Motherboard und den bereits vorhandenen RAM-Modulen kompatibel sein. Inkonsistenzen können zu Startproblemen führen.
                                
                Betriebssystemprobleme:
                Bestimmte Betriebssysteme benötigen möglicherweise spezielle Konfigurationen oder Treiber für neue Hardware. Stelle sicher, dass das Betriebssystem die neue Hardware unterstützt und die erforderlichen Updates installiert sind.
                """);
        sols.put("updateproblem", """
                Treiber aktualisieren: 
                Stelle sicher, dass deine Hardwaretreiber auf dem neuesten Stand sind.
                                
                Windows Update wiederholen: 
                Manchmal kann ein erneuter Versuch, das Update zu installieren, das Problem beheben.
                                
                Systemwiederherstellung: 
                Du kannst versuchen, das System auf einen vorherigen Zustand zurückzusetzen, wenn Probleme nach einem Update auftreten.
                                
                Überprüfe die Windows-Ereignisanzeige: 
                Hier findest du detaillierte Informationen zu Fehlern und Warnungen nach einem Update.
                                
                Deaktiviere vorübergehend Sicherheitssoftware: 
                Antivirenprogramme und Firewall können Updates beeinträchtigen. Deaktiviere sie vorübergehend, um zu prüfen, ob dies das Problem behebt.
                """);
        sols.put("windows-aktualisierung", """
                Überprüfe die Systemanforderungen:
                Vergewissere dich, dass dein Computer die Mindestanforderungen für Windows 11 erfüllt. Dazu gehören spezifische Anforderungen an die CPU, den Arbeitsspeicher, den Festplattenspeicher und die Grafikkarte.
                                
                Aktualisiere Windows 10 vollständig:
                Stelle sicher, dass dein Windows 10-System alle verfügbaren Updates installiert hat, bevor du versuchst, auf Windows 11 zu aktualisieren.
                                
                Verfügbarkeit prüfen:
                Überprüfe, ob Windows 11 offiziell für dein Gerät verfügbar ist. Nicht alle Geräte sind möglicherweise für ein Upgrade berechtigt.
                                
                Verbinde den PC mit dem Internet:
                Eine stabile Internetverbindung ist wichtig, um das Upgrade herunterzuladen und zu installieren. Stelle sicher, dass deine Verbindung während des gesamten Prozesses stabil ist.
                                
                Verwende das Media Creation Tool:
                Lade das offizielle Media Creation Tool von der Microsoft-Website herunter und führe damit das Upgrade durch. Das Tool kann helfen, Probleme während des Installationsprozesses zu umgehen.
                                
                Überprüfe auf Hardwareinkompatibilitäten:
                Überprüfe, ob deine Hardware mit Windows 11 kompatibel ist. Möglicherweise benötigst du Treiberaktualisierungen oder es gibt bestimmte Hardwarekomponenten, die nicht unterstützt werden.
                                
                Deaktiviere vorübergehend Sicherheitssoftware:
                Deaktiviere vorübergehend deine Antivirensoftware und die Windows-Firewall, da diese den Installationsprozess beeinträchtigen könnten. Vergiss nicht, sie nach dem Upgrade wieder zu aktivieren.
                                
                Überprüfe den Festplattenspeicher:
                Stelle sicher, dass ausreichend Speicherplatz auf deiner Festplatte für das Upgrade verfügbar ist. Windows 11 benötigt möglicherweise mehr Platz als Windows 10.
                                
                Behebe Treiberprobleme:
                Aktualisiere deine Treiber auf die neuesten Versionen, besonders Grafik- und Chipsatztreiber. Inkompatible oder veraltete Treiber können Installationsfehler verursachen.
                                
                Nutze das Windows Update-Problembehandlungstool:
                Windows verfügt über integrierte Problembehandlungstools. Du kannst das Windows Update-Problembehandlungstool ausführen, um mögliche Probleme zu identifizieren und zu beheben.
                                
                Überprüfe die Windows-Ereignisanzeige:
                Schau in die Windows-Ereignisanzeige nach möglichen Fehlermeldungen oder Warnungen während des Aktualisierungsprozesses.
                                
                Benutze den Update-Assistenten aus:
                Microsoft bietet möglicherweise einen speziellen Update-Assistenten für Windows 11 an. Überprüfe die offizielle Website, um sicherzustellen, dass du die neuesten Hilfsmittel verwendest.
                """);
        sols.put("nicht-windows-aktualisierung", """
                Neustart des Computers:
                Oftmals können Probleme durch einen einfachen Neustart behoben werden. Starte deinen Computer neu und sieh nach, ob der Fehler weiterhin besteht.
                                
                Überprüfung auf Malware:
                Manchmal können Malware-Infektionen zu Fehlern führen. Verwende eine zuverlässige Antivirensoftware, um deinen Computer auf Malware zu überprüfen und sie zu entfernen.
                                
                Systemdateien überprüfen und reparieren:
                Verwende die integrierten Windows-Tools, um beschädigte Systemdateien zu überprüfen und zu reparieren. Öffne die Eingabeaufforderung als Administrator und führe den Befehl sfc /scannow aus.
                                
                Überprüfung auf Festplattenfehler:
                Führe eine Überprüfung der Festplatte auf Fehler durch. Öffne die Eingabeaufforderung als Administrator und führe den Befehl chkdsk /f aus.
                                
                Deinstallation von kürzlich installierten Programmen:
                Wenn der Fehler nach der Installation eines bestimmten Programms aufgetreten ist, versuche, das Programm zu deinstallieren, um zu sehen, ob das Problem behoben wird.
                                
                Aktualisiere Treiber:
                Stelle sicher, dass alle deine Treiber auf dem neuesten Stand sind. Du kannst dies manuell tun, indem du die offizielle Website des Geräteherstellers besuchst, oder ein Tool wie den Geräte-Manager verwenden.
                                
                Ereignisanzeige überprüfen:
                Schaue in die Ereignisanzeige (Event Viewer), um detaillierte Informationen über Fehler und Warnungen zu erhalten. Dies kann dir helfen, das genaue Problem zu identifizieren.
                                
                Systemwiederherstellungspunkt verwenden:
                Falls der Fehler erst nach einer bestimmten Änderung aufgetreten ist, kannst du versuchen, das System auf einen früheren Zeitpunkt wiederherzustellen.
                """);
        sols.put("gpu", """
                Aktualisiere deine Grafiktreiber:
                Stelle sicher, dass deine Grafiktreiber auf dem neuesten Stand sind. Du kannst dies entweder manuell von der Website des Grafikkartenherstellers tun oder Tools wie den GeForce Experience für NVIDIA-Grafikkarten oder den AMD Radeon Software für AMD-Grafikkarten verwenden.
                                
                Überprüfe die Temperatur der GPU:
                Überhitzung kann zu Fehlern führen. Überwache die Temperatur deiner GPU mit Tools wie MSI Afterburner oder HWMonitor und stelle sicher, dass sie im sicheren Bereich bleibt. Falls die Temperatur zu hoch ist, könnte eine bessere Kühlung erforderlich sein.
                                
                Überprüfe die Stromversorgung:
                Stelle sicher, dass deine GPU ausreichend mit Strom versorgt wird. Überprüfe die Anschlüsse und Kabel, und vergewissere dich, dass die Stromversorgung den Anforderungen der Grafikkarte entspricht.
                                
                Deaktiviere Overclocking:
                Wenn du Overclocking aktiviert hast, deaktiviere es vorübergehend, um zu sehen, ob dies das Problem behebt. Manchmal können instabile Overclocking-Einstellungen zu Fehlern führen.
                                
                Überprüfe auf Konflikte mit anderen Hardwarekomponenten:
                Stelle sicher, dass es keine Konflikte mit anderen Hardwarekomponenten gibt, insbesondere wenn du kürzlich neue Hardware installiert hast. Überprüfe auch, ob alle Hardwarekomponenten richtig in ihren Steckplätzen sitzen.
                                
                Überprüfe auf Softwarekonflikte:
                Manchmal können Softwarekonflikte, insbesondere mit Sicherheitssoftware oder anderen Grafikprogrammen, zu Problemen führen. Deaktiviere vorübergehend Antivirensoftware oder Firewalls, um zu sehen, ob dies eine Auswirkung hat.
                                
                Überprüfe die Systemprotokolle:
                Schaue in die Systemprotokolle deines Betriebssystems, um nach Hinweisen auf GPU-Fehler zu suchen. Die Ereignisanzeige in Windows ist eine nützliche Ressource für solche Informationen.
                                
                Teste die GPU in einem anderen System:
                Falls möglich, teste die GPU in einem anderen System, um sicherzustellen, dass das Problem nicht auf Hardwareprobleme zurückzuführen ist.
                                
                Firmware- und BIOS-Update:
                Überprüfe, ob es für deine GPU Firmware- oder BIOS-Updates gibt, und aktualisiere sie gegebenenfalls.
                """);
        sols.put("cpu", """
                Überprüfe die Temperaturen:
                Überhitzung kann zu CPU-Fehlern führen. Überwache die Temperatur deiner CPU mit Tools wie HWMonitor oder Core Temp und stelle sicher, dass sie sich im normalen Bereich bewegt. Wenn die Temperatur zu hoch ist, könnte eine bessere Kühlung erforderlich sein.
                                
                Aktualisiere das BIOS/UEFI:
                Überprüfe, ob es für dein Mainboard ein BIOS- oder UEFI-Update gibt, und führe es gegebenenfalls durch. Manchmal können veraltete Firmware-Versionen zu Inkompatibilitäten führen.
                                
                Aktualisiere Treiber:
                Stelle sicher, dass alle Treiber auf dem neuesten Stand sind, insbesondere der Chipsatztreiber für das Mainboard und der Treiber für die CPU. Du kannst dies auf der Website des Herstellers oder über Windows Update tun.
                                
                Überprüfe auf Hardwarefehler:
                Überprüfe, ob es Probleme mit anderen Hardwarekomponenten gibt, die mit der CPU interagieren, wie RAM oder Grafikkarte. Defekte Hardware kann zu CPU-Fehlern führen.
                                
                Deaktiviere Overclocking:
                Wenn du Overclocking aktiviert hast, deaktiviere es vorübergehend, um zu sehen, ob dies das Problem behebt. Übertaktung kann zu Instabilität führen, insbesondere wenn sie nicht korrekt konfiguriert ist.
                                
                Überprüfe auf Malware:
                Führe einen vollständigen Virenscan durch, um sicherzustellen, dass Malware nicht die Ursache des Problems ist. Malware kann die CPU-Ressourcen stark belasten.
                                
                Überwache die Systemauslastung:
                Verwende den Task-Manager, um die Auslastung der CPU und des Arbeitsspeichers zu überwachen. Dies kann dir helfen, herauszufinden, welche Anwendungen oder Prozesse die Ressourcen deiner CPU beanspruchen.
                                
                Ereignisanzeige überprüfen:
                Schaue in die Ereignisanzeige (Event Viewer), um nach Fehlermeldungen oder Warnungen zu suchen, die mit der CPU in Verbindung stehen könnten.
                """);
        sols.put("psu", """
                Überprüfe die Verbindungen:
                Stelle sicher, dass alle Kabel und Stecker korrekt und fest angeschlossen sind. Überprüfe sowohl die Verbindung zum Netzteil als auch zu den Komponenten im Computer, wie der Hauptplatine, der Grafikkarte und den Laufwerken.
                                
                Teste mit einem anderen Netzteil:
                Wenn möglich, teste den Computer mit einem anderen, funktionsfähigen Netzteil. Dies kann helfen zu bestimmen, ob das aktuelle Netzteil das Problem verursacht.
                                
                Überprüfe die Stromversorgung:
                Stelle sicher, dass das Netzteil ausreichend Strom für die angeschlossenen Komponenten bereitstellt. Manchmal kann ein zu schwaches Netzteil zu Instabilitäten führen. Überprüfe auch, ob die Spannungen den Spezifikationen entsprechen.
                                
                Überwache die Temperaturen:
                Ein überhitztes Netzteil kann fehlerhaft arbeiten. Überwache die Temperaturen im Computergehäuse und stelle sicher, dass das Netzteil ausreichend gekühlt wird.
                                
                Prüfe auf visuelle Anzeichen:
                Schau dir das Netzteil genau an. Wenn du Anzeichen von physischen Schäden wie geplatzten Kondensatoren oder verbrannten Gerüchen bemerkst, könnte dies auf einen Defekt hinweisen.
                                
                Verwende ein Spannungsprüfgerät:
                Ein Spannungsprüfgerät kann helfen, die Spannungen an den Anschlüssen des Netzteils zu überprüfen. Achte darauf, dass die Spannungen den Spezifikationen entsprechen.
                                
                Schließe unnötige Komponenten an:
                Reduziere die Last auf das Netzteil, indem du unnötige Komponenten abklemmst. Dadurch kannst du feststellen, ob das Netzteil möglicherweise überlastet ist.
                                
                Aktualisiere das BIOS/UEFI:
                Überprüfe, ob es für dein Mainboard ein BIOS- oder UEFI-Update gibt, und führe es durch. Manchmal können Inkompatibilitäten zwischen dem Mainboard und dem Netzteil durch Firmware-Updates behoben werden.
                """);
        sols.put("mainboard", """
                Visuelle Inspektion:
                Schau dir das Mainboard sorgfältig an, um Anzeichen von physischen Schäden wie geplatzten Kondensatoren oder Verfärbungen zu erkennen. Einige Probleme können visuell erkennbar sein.
                                
                Überprüfe die Verbindungen:
                Stelle sicher, dass alle Komponenten korrekt in die entsprechenden Steckplätze eingesteckt sind. Überprüfe auch die Stromversorgung und die Verbindungen zu CPU, RAM, Grafikkarte und anderen Hardwarekomponenten.
                                
                Entferne nicht notwendige Komponenten:
                Reduziere die Konfiguration auf das Minimum, indem du alle nicht notwendigen Komponenten (z.B., zusätzliche RAM-Riegel, Erweiterungskarten) entfernst. Teste dann das System, um festzustellen, ob das Mainboard stabil bleibt.
                                
                Teste mit minimaler Hardware:
                Schließe nur die grundlegenden Hardwarekomponenten an, wie CPU, RAM und Grafikkarte. Wenn das System startet, füge nach und nach weitere Komponenten hinzu, um die fehlerhafte Komponente zu identifizieren.
                                
                Überprüfe RAM-Module:
                Teste jedes RAM-Modul einzeln und in verschiedenen Slots. Defekter RAM kann zu instabilen Systemen führen. Du kannst auch Memtest86 verwenden, um den RAM auf Fehler zu überprüfen.
                                
                Überprüfe die Stromversorgung:
                Stelle sicher, dass das Netzteil ausreichend Leistung liefert und korrekt funktioniert. Teste gegebenenfalls mit einem anderen Netzteil.
                                
                Überwache die Systemtemperaturen:
                Überhitzung kann zu Fehlern führen. Überwache die Temperaturen im Computergehäuse und stelle sicher, dass die Lüfter richtig funktionieren.
                                
                Bios/UEFI zurücksetzen:
                Setze das Bios/UEFI auf die Standardeinstellungen zurück. Ein fehlerhaftes Bios kann zu Problemen führen.
                                
                Aktualisiere das Bios/UEFI:
                Überprüfe, ob für dein Mainboard ein Bios/UEFI-Update verfügbar ist. Ein Firmware-Update kann Kompatibilitätsprobleme beheben.
                                
                Teste mit einem Ersatz-Mainboard:
                Wenn möglich, teste mit einem Ersatz-Mainboard, um festzustellen, ob das Problem am Mainboard selbst liegt.
                """);
        sols.put("luefter", """
                Überprüfe die Verbindungen:
                Stelle sicher, dass der Lüfter richtig mit dem Motherboard oder der Lüftersteuerung verbunden ist. Manchmal können lockere Verbindungen zu Fehlfunktionen führen.
                                
                Reinige den Lüfter:
                Staub und Schmutz können die Lüfterblätter behindern und die Kühlleistung beeinträchtigen. Schalte den PC aus, entferne den Lüfter und reinige ihn vorsichtig mit Druckluft oder einem weichen Pinsel.
                                
                Ersatz des Lüfters:
                Wenn der Lüfter defekt ist, könnte ein Ersatz erforderlich sein. Du kannst einen identischen Ersatzlüfter kaufen und ihn selbst austauschen. Achte darauf, dass der neue Lüfter die gleichen Spezifikationen wie der alte hat.
                                
                Schmierung des Lüfterlagers:
                Manche Lüfter haben Lager, die geschmiert werden können. Wenn der Lüfter Geräusche macht, könnte das Schmieren des Lüfterlagers das Problem beheben. Dazu musst du jedoch den Lüfter auseinandernehmen, was nicht bei allen Modellen möglich oder ratsam ist.
                                
                Kontrolliere die Lüftersteuerung:
                Wenn dein PC eine Lüftersteuerung hat, überprüfe die Einstellungen, um sicherzustellen, dass die Lüfter richtig konfiguriert sind. Manchmal können falsche Einstellungen zu einer ineffizienten Kühlung führen.
                                
                Bios/UEFI-Einstellungen überprüfen:
                Stelle sicher, dass die Lüfter im Bios/UEFI korrekt eingestellt sind. Manche Motherboards bieten Optionen zur Steuerung der Lüftergeschwindigkeit und -steuerung.
                """);
        sols.put("browser", """
                Neustart des Browsers:
                Ein einfacher Neustart des Browsers kann viele Probleme beheben. Schließe den Browser und öffne ihn erneut.
                                
                Browser-Cache leeren:
                Gespeicherte Cache-Daten können zu Anzeigefehlern führen. Lösche den Cache deines Browsers, um sicherzustellen, dass du die neueste Version der Webseite lädst.
                                
                Cookies löschen:
                Manchmal können fehlerhafte Cookies Probleme verursachen. Lösche die Cookies im Browser und versuche es erneut.
                                
                Deaktiviere Browsererweiterungen:
                Deaktiviere alle Browsererweiterungen oder Plugins, da diese zu Konflikten führen können. Starte den Browser neu und überprüfe, ob das Problem weiterhin besteht.
                                
                Aktualisiere den Browser:
                Stelle sicher, dass du die neueste Version deines Browsers verwendest. Aktualisiere ihn bei Bedarf über die Einstellungen oder die offizielle Website des Browsers.
                                
                Überprüfe Internetverbindung:
                Eine instabile Internetverbindung kann zu Lade- oder Anzeigefehlern führen. Überprüfe deine Internetverbindung und starte gegebenenfalls den Router neu.
                                
                Browser-Add-ons deaktivieren:
                Einige Browser-Add-ons können Probleme verursachen. Deaktiviere sie nacheinander, um festzustellen, ob eines davon das Problem verursacht.
                                
                Antivirus- und Firewall-Einstellungen überprüfen:
                Manchmal können Antivirus- oder Firewall-Einstellungen den Zugriff des Browsers auf bestimmte Websites blockieren. Überprüfe diese Einstellungen und passe sie gegebenenfalls an.
                                
                Proxy-Einstellungen überprüfen:
                Stelle sicher, dass deine Proxy-Einstellungen korrekt konfiguriert sind. Wenn du keinen Proxy benötigst, setze die Einstellungen auf "Automatisch erkennen".""");
        sols.put("mc-office", """
                Office-Anwendungen aktualisieren:
                Stelle sicher, dass du die neueste Version von Microsoft Office installiert hast. Aktualisiere die Anwendungen über das Office-Update oder den Microsoft Store.
                                
                Neustart der Anwendung:
                Schließe die betroffene Office-Anwendung und starte sie neu. Ein einfacher Neustart kann viele temporäre Probleme beheben.
                                
                Überprüfe auf Windows-Updates:
                Stelle sicher, dass dein Betriebssystem auf dem neuesten Stand ist. Führe Windows-Updates durch, da sie auch Patches für Microsoft Office enthalten können.
                                
                Abgesicherter Modus:
                Starte die Office-Anwendung im abgesicherten Modus. Dies deaktiviert Add-ins und benutzerdefinierte Einstellungen, um festzustellen, ob ein Add-in das Problem verursacht.
                                
                Repariere Microsoft Office:
                Microsoft Office bietet eine Reparaturfunktion, die beschädigte Dateien ersetzt. Gehe zu "Systemsteuerung" > "Programme" > "Programme und Funktionen", wähle Microsoft Office aus und klicke auf "Ändern". Wähle dann die Option zur Reparatur aus.
                                
                Überprüfe auf Konflikte mit Add-ins:
                Deaktiviere nicht benötigte Add-ins oder Erweiterungen. Gehe zu den Einstellungen der Office-Anwendung und deaktiviere schrittweise Add-ins, um zu sehen, ob das Problem behoben ist.
                                
                Lösche den Office-Cache:
                Office-Anwendungen speichern einige Daten im Cache, was zu Fehlern führen kann. Lösche den Office-Cache, indem du die temporären Dateien und den Cache-Ordner löschst.
                                
                Windows Defender oder Antivirus-Einstellungen überprüfen:
                Stelle sicher, dass dein Antivirus-Programm oder Windows Defender keine Office-Dateien blockiert. Überprüfe die Einstellungen und füge Office-Anwendungen zur Ausnahmeliste hinzu.""");
        sols.put("sicherheit", """
                Aktualisiere das Sicherheitsprogramm:
                Stelle sicher, dass das Sicherheitsprogramm auf dem neuesten Stand ist. Aktualisiere es durch Ausführen von Updates über die Programmoberfläche oder die offizielle Website des Herstellers.
                                
                Neustart des Computers:
                Ein einfacher Neustart kann viele temporäre Probleme mit Sicherheitsprogrammen beheben. Starte deinen Computer neu und überprüfe, ob der Fehler weiterhin besteht.
                                
                Überprüfe auf Konflikte mit anderen Programmen:
                Manchmal können Sicherheitsprogramme mit anderen installierten Anwendungen oder Treibern in Konflikt geraten. Deaktiviere vorübergehend andere Sicherheitsanwendungen oder Software und prüfe, ob das Problem weiterhin besteht.
                                
                Fehlerprotokolle überprüfen:
                Viele Sicherheitsprogramme verfügen über Protokolle, die Fehler und Warnungen aufzeichnen. Überprüfe diese Protokolle auf Informationen zum aufgetretenen Fehler.
                                
                Überprüfe Einstellungen und Ausnahmen:
                Stelle sicher, dass die Einstellungen des Sicherheitsprogramms korrekt konfiguriert sind. Überprüfe, ob Dateien, Ordner oder Anwendungen, die du verwenden möchtest, nicht durch die Sicherheitssoftware blockiert werden.
                                
                Führe einen vollständigen Systemscan durch:
                Starte einen vollständigen Systemscan, um nach Malware oder anderen Bedrohungen zu suchen, die möglicherweise das Sicherheitsprogramm beeinträchtigen.
                                
                Deinstalliere und installiere das Sicherheitsprogramm neu:
                Wenn das Problem weiterhin besteht, deinstalliere das Sicherheitsprogramm und installiere es erneut. Dies kann beschädigte Dateien oder Einstellungen beheben.
                                
                Überprüfe die Lizenz und Abo-Status:
                Stelle sicher, dass die Lizenz des Sicherheitsprogramms aktiv und gültig ist. Manchmal können Lizenzprobleme zu Fehlern führen.
                """);
        sols.put("multimedia", """
                Aktualisiere die Software:
                Stelle sicher, dass du die neueste Version der jeweiligen Software installiert hast. Updates beinhalten oft Fehlerbehebungen und verbesserte Funktionen.
                                
                Neustart:
                Starte den Computer neu, um temporäre Probleme zu beheben und sicherzustellen, dass alle Systemressourcen ordnungsgemäß funktionieren.
                                
                Treiber überprüfen:
                Überprüfe, ob deine Treiber auf dem neuesten Stand sind, insbesondere Audio- und Grafiktreiber, da diese oft für die Funktion von Multimedia-Software wichtig sind.
                                
                Einstellungen zurücksetzen:
                Setze die Einstellungen der Software auf die Standardeinstellungen zurück. Dies kann durch Zurücksetzen von Konfigurationsdateien oder über die Einstellungen der jeweiligen Anwendung erfolgen.
                                
                Cache leeren:
                Leere Cache-Dateien oder temporäre Dateien, um sicherzustellen, dass die Software mit frischen Daten arbeitet.
                                
                Deaktiviere vorübergehend Sicherheitssoftware:
                Deaktiviere vorübergehend Firewall oder Antivirenprogramme, um sicherzustellen, dass sie nicht die normale Funktion der Software beeinträchtigen.
                                
                Plugin-Kompatibilität überprüfen (bei Musikproduktionssoftware):
                Überprüfe, ob alle verwendeten Plugins mit der Software kompatibel sind. Inkompatibilitäten können zu Fehlern führen.
                                
                Support-Ressourcen des Herstellers nutzen:
                Konsultiere die offiziellen Support-Ressourcen der jeweiligen Softwarehersteller, wie Handbücher, Foren oder FAQ-Seiten, um spezifische Lösungen zu finden.
                                
                Online-Community-Foren:
                Suche in Community-Foren nach ähnlichen Problemen. Oft teilen andere Benutzer ihre Erfahrungen und Lösungen.
                                
                Deinstalliere und installiere die Software neu:
                Deinstalliere die betroffene Software und installiere sie erneut. Dadurch werden möglicherweise beschädigte Dateien ersetzt.""");
        sols.put("office-tools", """
                Neustart der Anwendung:
                Oftmals können Probleme durch einen einfachen Neustart der Anwendung behoben werden. Schließen Sie die Anwendung und starten Sie sie erneut.
                                
                Aktualisierung der Software:
                Stellen Sie sicher, dass Sie die neueste Version der jeweiligen Anwendung verwenden. Updates enthalten oft Fehlerbehebungen und verbesserte Leistung.
                                
                Überprüfung der Systemanforderungen:
                Vergewissern Sie sich, dass Ihr Computer die Systemanforderungen für die jeweilige Anwendung erfüllt. Manchmal können Probleme auftreten, wenn die Hardware oder Software nicht den Mindestanforderungen entspricht.
                                
                Überprüfung der Internetverbindung:
                Bei Anwendungen, die eine Internetverbindung erfordern, stellen Sie sicher, dass Ihre Verbindung stabil ist. Probleme mit der Netzwerkverbindung können zu Fehlern führen.
                                
                Überprüfung von Add-ons und Erweiterungen:
                Deaktivieren Sie vorübergehend alle Add-ons, Erweiterungen oder Plugins, die Sie in der Anwendung installiert haben. Manchmal können diese zu Konflikten führen.
                                
                Löschen von Zwischenspeicher und temporären Dateien:
                Löschen Sie temporäre Dateien und den Zwischenspeicher der Anwendung. Dies kann dazu beitragen, Probleme im Zusammenhang mit beschädigten oder veralteten Dateien zu beheben.
                                
                Überprüfung von Protokolldateien:
                Suchen Sie nach Protokolldateien oder Fehlermeldungen in der Anwendung. Diese können Hinweise darauf geben, was das Problem verursacht.""");
        sols.put("kommunikation", """
                Überprüfung der Internetverbindung:
                Stellen Sie sicher, dass Ihre Internetverbindung stabil ist. Probleme mit der Verbindung können zu Audio- und Videoqualitätsproblemen führen.
                                
                Aktualisierung der Software:
                Vergewissern Sie sich, dass Sie die neueste Version der jeweiligen Kommunikationssoftware verwenden. Updates enthalten oft Fehlerkorrekturen und Verbesserungen.
                                
                Überprüfung von Mikrofon und Kamera:
                Stellen Sie sicher, dass Ihr Mikrofon und Ihre Kamera ordnungsgemäß funktionieren. Überprüfen Sie die Einstellungen der Software, um sicherzustellen, dass die richtigen Geräte ausgewählt sind.
                                
                Überprüfung von Berechtigungen:
                Achten Sie darauf, dass die Anwendung die notwendigen Berechtigungen für den Zugriff auf Mikrofon, Kamera und andere Ressourcen hat.
                                
                Deaktivierung von Hintergrundanwendungen:
                Schließen Sie andere Anwendungen und Programme im Hintergrund, die Ressourcen verbrauchen könnten. Dies kann die Leistung der Kommunikationssoftware verbessern.
                                
                Neustart der Anwendung:
                Beenden Sie die Anwendung und starten Sie sie erneut. Manchmal können temporäre Probleme durch einen Neustart behoben werden.
                                
                Überprüfung von Firewall- und Antiviren-Einstellungen:
                Stellen Sie sicher, dass Ihre Firewall und Ihr Antivirenprogramm die Kommunikationssoftware nicht blockieren. Passen Sie gegebenenfalls die Einstellungen an.
                                
                Überprüfung von Serverstatus und Störungsmeldungen:
                Überprüfen Sie den Serverstatus der Kommunikationsplattform. Manchmal können Störungen auftreten, die außerhalb Ihrer Kontrolle liegen.
                                
                Aktualisierung von Treibern:
                Stellen Sie sicher, dass Ihre Audio- und Videotreiber auf dem neuesten Stand sind. Veraltete Treiber können zu Kompatibilitätsproblemen führen.""");
        solutions = sols;
    }
}