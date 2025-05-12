#!/usr/bin/env python3

"""
Script to generate resource files for the mod
"""

import json
import os

def generate_lang_files():
    """Generate language files in the correct format"""
    languages = ['en_us', 'fr_fr', 'es_es']
    base_path = 'src/main/resources/assets/millenaire/lang'
    
    for lang in languages:
        os.makedirs(base_path, exist_ok=True)
        with open(f'{base_path}/{lang}.json', 'w') as f:
            json.dump({
                "item.millenaire.village_map": "Village Map",
                "item.millenaire.civilisation_scroll": "Civilisation Scroll"
            }, f, indent=2)

if __name__ == '__main__':
    generate_lang_files()
    print("Resource files generated successfully")
